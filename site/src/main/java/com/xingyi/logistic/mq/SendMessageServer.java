package com.xingyi.logistic.mq;

import com.xingyi.logistic.business.model.DispatchPlan;
import com.xingyi.logistic.business.model.TerminalMsg;
import com.xingyi.logistic.business.model.TextMessageSend;
import com.xingyi.logistic.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

/**
 * Created by WCL on 2018/1/12.
 */
@Component
public class SendMessageServer
{
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    //发送文本
    private static String SEND_TERMINAL_MSG_QUEUE = "TEXTMESSAGESEND.QUEUE";

    //下发调度
    private static String DISPATCHPLANSEND_QUEUE = "DISPATCHPLANSEND.QUEUE";

    //取消调度
    private static String DISPATCHPLANSEND_CANCEL_QUEUE = "DISPATCHPLANSENDCANCEL.QUEUE";

    /**
     * 向终端下发调度任务
     * @param dispatchPlan
     * @throws JAXBException
     */
    public void funSendMsg(DispatchPlan dispatchPlan)
    {

        String xmlObj = getXml(dispatchPlan.getClass(), dispatchPlan);
        jmsMessagingTemplate.convertAndSend(DISPATCHPLANSEND_QUEUE, xmlObj);
    }

    /**
     * 向终端下发取消调度的命令
     * @param dispatchPlan
     */
    public void funSendCancelMsg(DispatchPlan dispatchPlan)
    {
        String xmlObj = getXml(dispatchPlan.getClass(), dispatchPlan);
        jmsMessagingTemplate.convertAndSend(DISPATCHPLANSEND_CANCEL_QUEUE, xmlObj);
    }


    /**
     * 下发文本调度
     * @param obj
     */
    public void funTerminalMsg(TerminalMsg terminalMsg)
    {

        TextMessageSend mObj = new TextMessageSend();
        mObj.setTextmessageid(terminalMsg.getId());
        mObj.setDevicecode(terminalMsg.getDeviceId());
        mObj.setTextmessage(terminalMsg.getContent());
        mObj.setTextmessagetitle(terminalMsg.getTitle());
        mObj.setServertime(DateUtils.getCurrentSystemTime());
        String xmlObj = getXml(TextMessageSend.class, mObj);
        System.out.println(xmlObj);
        jmsMessagingTemplate.convertAndSend(SEND_TERMINAL_MSG_QUEUE, xmlObj);
    }



    /**
     * 处理消息中的XML内容
     * @param cls
     * @param mObj
     * @return
     */
    public String getXml(Class cls, Object mObj)
    {
        String retXml = "";
        try
        {
            JAXBContext context = JAXBContext.newInstance(cls);
            Marshaller marshaller = context.createMarshaller(); // 根据上下文获取marshaller对象
            //marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");  // 设置编码字符集
            // marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 格式化XML输出，有分行和缩进
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);// 去掉生成xml的默认报文头
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            marshaller.marshal(mObj, baos);
            retXml = new String(baos.toByteArray());
            System.out.println(retXml);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return retXml;
    }

}
