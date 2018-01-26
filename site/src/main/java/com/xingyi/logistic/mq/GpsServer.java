package com.xingyi.logistic.mq;

import com.xingyi.logistic.business.model.SendCmdSp;
import com.xingyi.logistic.business.model.ShipCurrentGps;
import com.xingyi.logistic.business.model.ShipCurrentGpsQuery;
import com.xingyi.logistic.business.model.ShipDev;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShipCurrentGpsService;
import com.xingyi.logistic.controller.BaseCRUDController;
import com.xingyi.logistic.util.ManageShipCurrentGps;
import com.xingyi.logistic.util.ManageShipDev;
import org.apache.commons.collections.map.HashedMap;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by WCL on 2018/1/12.
 */
@Component
public class GpsServer extends BaseCRUDController<ShipCurrentGps, ShipCurrentGpsQuery>
{
    private static ManageShipCurrentGps manageShipCurrentGps = new ManageShipCurrentGps();

    private static LinkedBlockingQueue<Map<String, String>> rec_queue = new LinkedBlockingQueue<>();

    public ManageShipDev mManageShipDev = new ManageShipDev();
    @Autowired
    private ShipCurrentGpsService shipCurrentGpsService;

    @PostConstruct
    public void init()
    {
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(mTimeLoading, 0, 10, TimeUnit.MINUTES);

        List<ShipCurrentGps> shiGpsFlys = shipCurrentGpsService.getShipCurrentGpsAll();
        for (ShipCurrentGps shipCurrentGps : shiGpsFlys)
        {
            manageShipCurrentGps.add(shipCurrentGps);
        }
        System.out.println("shipCurrentGpsService---------------------" + shiGpsFlys.size());
        SaveThread mSaveThread = new SaveThread();
        mSaveThread.start();

        SaveSendCmdSpThread mSaveSendCmdSpThread = new SaveSendCmdSpThread();
        mSaveSendCmdSpThread.start();


    }


    /**
     * 定位数据接收
     * @param xml
     * @throws Exception
     */
    @Async
    public void executeLocationTask(String xml)
    {
        //System.out.println(xml);
        manageShipCurrentGps.add(dealXml(xml));
    }

    /**
     * 解析进站数据
     * @param xml
     */
    @Async
    public void executeEnterStationTask(String xml)
    {
        //System.out.println("--------------进");
        //System.out.println(xml);
        manageShipCurrentGps.addEnterStation(dealXml(xml));
    }



    /**
     * 解析出站数据
     * @param xml
     */
    @Async
    public void executeLeaveStationTask(String xml)
    {
        //System.out.println("--------------出");
        //System.out.println(xml);
        manageShipCurrentGps.addLeaveStation(dealXml(xml));
    }

    /**
     * 通用应答
     * @param xml
     */
    @Async
    public void executeSendCmdSpTask(String xml)
    {
        Map<String, String> xmlMap = dealXml(xml);
        try {
            rec_queue.put(xmlMap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理XML数据，转为MAP对象
     * @param xml
     * @return
     */
    private Map dealXml(String xml)
    {
        Map<String, String> xmlMap = new HashedMap();
        try
        {
            Document doc = DocumentHelper.parseText(xml);
            Element root = doc.getRootElement();
            listNodes(root, xmlMap);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return xmlMap;
    }


    /**
     * 循环处理XML数据
     * @param node
     * @param xmlMap
     */
    private void listNodes(Element node, Map<String, String> xmlMap)
    {
        xmlMap.put(node.getName(), node.getText());

        // 当前节点下面子节点迭代器
        Iterator<Element> it = node.elementIterator();
        // 遍历
        while (it.hasNext())
        {
            // 获取某个子节点对象
            Element e = it.next();
            // 对子节点进行遍历
            listNodes(e, xmlMap);
        }
    }

    @Override
    protected BaseService<ShipCurrentGps, ShipCurrentGpsQuery> getBaseService() {
        return shipCurrentGpsService;
    }


    private static AtomicInteger updatecount = new AtomicInteger(0);

    class SaveThread extends  Thread
    {
        public SaveThread()
        {
            this.setName("--SaveThread");
        }

        @Override
        public void run()
        {
            while (true)
            {

                Enumeration<ShipCurrentGps> en2 = manageShipCurrentGps.mHashMap.elements();
                while (en2.hasMoreElements())
                {
                    ShipCurrentGps mShipCurrentGps = en2.nextElement();
                    if (mShipCurrentGps != null && mShipCurrentGps.getUpstatue() == 0)
                    {
                        updatecount.incrementAndGet();
                        mShipCurrentGps.setShipNo(mManageShipDev.getShipNo(mShipCurrentGps.getDevId()));
                        mShipCurrentGps.setUpstatue(1);
                        if (mShipCurrentGps.getIsSaveDb() == 1)
                        {
                            shipCurrentGpsService.modify(mShipCurrentGps);
                        }
                        else
                        {
                            mShipCurrentGps.setIsSaveDb(1);
                            shipCurrentGpsService.add(mShipCurrentGps);

                        }
                       // System.out.println(mShipCurrentGps.toString());
                    }
                }
                try {
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println("manageShipCurrentGps----"+ updatecount.get()+"----------------" + manageShipCurrentGps.size());
                updatecount.getAndSet(0);
            }
        }
    }


    class SaveSendCmdSpThread extends  Thread
    {
        public SaveSendCmdSpThread()
        {
            this.setName("--SaveSendCmdSpThread");
        }
        @Override
        public void run()
        {
            Map<String, String> xmlMap = null;
            SendCmdSp sendCmdSp = new SendCmdSp();
            while (true)
            {
                try
                {
                    xmlMap = rec_queue.take();
                    sendCmdSp.setType(Integer.parseInt(xmlMap.get("cmdtype")));
                    sendCmdSp.setCmd(Integer.parseInt(xmlMap.get("cmd")));
                    sendCmdSp.setErrorcode(xmlMap.get("errorcode"));
                    sendCmdSp.setStime(xmlMap.get("occurtime"));
                    sendCmdSp.setStatus(Integer.parseInt(xmlMap.get("success")));
                    //Thread.sleep(5000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println("SaveSendCmdSpThread----"+ rec_queue.size()+"----------------" + rec_queue.size());
            }
        }
    }

    private Runnable mTimeLoading = new Runnable()
    {
        @Override
        public void run()
        {
            List<ShipDev> argFlys = shipCurrentGpsService.getShipDev();
            System.out.println("定时加载设备============ size = " + argFlys.size());
            if (argFlys != null)
            {
                for (ShipDev shipDev : argFlys)
                {
                    mManageShipDev.add(shipDev);
                }
            }
        }
    };
}
