package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.TerminalMsg;
import com.xingyi.logistic.business.model.TerminalMsgQuery;
import com.xingyi.logistic.business.mq.SendMessageServer;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.TerminalMsgService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Biz("终端消息")
@RestController
@RequestMapping("/terminalMsg")
public class TerminalMsgController extends BaseCRUDController<TerminalMsg,TerminalMsgQuery>{
    @Autowired
    TerminalMsgService terminalMsgService;

    @Autowired
    private SendMessageServer sendMessageServer;

    @Override
    public JsonRet<Long> add(@JsonParam TerminalMsg terminalMsg)
    {
        JsonRet mJsonRet =  super.add(terminalMsg);
        if (mJsonRet.isSuccess())
        {
            terminalMsg.setId(Long.parseLong(mJsonRet.getData().toString()));
            sendMessageServer.funTerminalMsg(terminalMsg);
        }
        return mJsonRet;
    }

    @Override
    protected BaseService<TerminalMsg,TerminalMsgQuery> getBaseService() {
        return terminalMsgService;
    }
}
