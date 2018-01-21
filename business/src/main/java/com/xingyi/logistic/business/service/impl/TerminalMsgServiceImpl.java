package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.TerminalMsgDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.TerminalMsgDBQuery;
import com.xingyi.logistic.business.db.entity.TerminalMsgDO;
import com.xingyi.logistic.business.model.TerminalMsg;
import com.xingyi.logistic.business.model.TerminalMsgQuery;
import com.xingyi.logistic.business.service.TerminalMsgService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.TerminalMsgConverter;
import com.xingyi.logistic.business.service.converter.TerminalMsgQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TerminalMsgServiceImpl extends BaseCRUDService<TerminalMsgDO,TerminalMsg,TerminalMsgDBQuery,TerminalMsgQuery> implements TerminalMsgService{

    @Autowired
    private TerminalMsgDAO terminalMsgDAO;

    @Autowired
    private TerminalMsgConverter terminalMsgConverter;

    @Autowired
    private TerminalMsgQueryConverter terminalMsgQueryConverter;

    @Override
    protected ModelConverter<TerminalMsgDO, TerminalMsg> getModelConverter() {
        return terminalMsgConverter;
    }

    @Override
    protected BaseDAO<TerminalMsgDO, TerminalMsgDBQuery> getDAO() {
        return terminalMsgDAO;
    }

    @Override
    protected QueryConditionConverter<TerminalMsgQuery, TerminalMsgDBQuery> getConditionConverter() {
        return terminalMsgQueryConverter;
    }
}
