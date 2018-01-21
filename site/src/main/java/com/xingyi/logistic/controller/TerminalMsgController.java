package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.TerminalMsg;
import com.xingyi.logistic.business.model.TerminalMsgQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.TerminalMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/terminalMsg")
public class TerminalMsgController extends BaseCRUDController<TerminalMsg,TerminalMsgQuery>{
    @Autowired
    TerminalMsgService terminalMsgService;

    @Override
    protected BaseService<TerminalMsg,TerminalMsgQuery> getBaseService() {
        return terminalMsgService;
    }
}
