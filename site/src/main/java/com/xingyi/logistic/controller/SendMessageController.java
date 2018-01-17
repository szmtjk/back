package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.DispatchPlan;
import com.xingyi.logistic.mq.SendMessageServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by WCL on 2018/1/11.
 */
@RestController
@RequestMapping("/sendmsg")
public class SendMessageController
{

    @Autowired
    private SendMessageServer sendMessageServer;


    @RequestMapping(value = "/se")
    public String home() throws Exception
    {
        DispatchPlan mDisp = new DispatchPlan();
        mDisp.setDevicecode("1");
        mDisp.setDispatchplansendid(2);
        mDisp.setEndfieldcode("3");
        mDisp.setEndfieldname("4");
        mDisp.setLinecode("5");
        mDisp.setPlanruntime("6");
        mDisp.setServertime("7");
        sendMessageServer.funSendMsg(mDisp);
        return "hello springboot";
    }
}
