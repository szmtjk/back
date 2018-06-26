package com.xingyi.logistic.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by WCL on 2018/1/11.
 */
@Component
public class MessageHandler
{

    @Autowired
    private GpsServer gpsServer;

    /**
     * 用户于接收定位数据的
     * @param msg
     */
    @JmsListener(destination = "LOCATION.QUEUE")
    public void receiveLocationQueue(String msg)
    {
        gpsServer.executeLocationTask(msg);
    }

    /**
     * 接收进站数据
     * @param msg
     */
    @JmsListener(destination = "ENTERSTATION.QUEUE")
    public void receiveEnterStationQueue(String msg)
    {
        System.out.println("receiveEnterStationQueue:" + msg);
        gpsServer.executeEnterStationTask(msg);
    }

    @JmsListener(destination = "LEAVESTATION.QUEUE")
    public void receiveLeaveStationQueue(String msg)
    {
        gpsServer.executeLeaveStationTask(msg);
    }

    @JmsListener(destination = "SENDCMDSP.QUEUE")
    public void receiveSendCmdSpQueue(String msg)
    {
        gpsServer.executeSendCmdSpTask(msg);
    }

}

