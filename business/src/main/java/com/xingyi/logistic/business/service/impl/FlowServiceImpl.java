package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.FlowDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.FlowDO;
import com.xingyi.logistic.business.db.entity.FlowDBQuery;
import com.xingyi.logistic.business.model.Flow;
import com.xingyi.logistic.business.model.FlowQuery;
import com.xingyi.logistic.business.service.FlowService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.FlowConverter;
import com.xingyi.logistic.business.service.converter.FlowQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 流向信息
 */
@Service
public class FlowServiceImpl extends BaseCRUDService<FlowDO, Flow, FlowDBQuery, FlowQuery> implements FlowService {

    @Autowired
    private FlowDAO flowDAO;

    @Autowired
    private FlowConverter flowConverter;

    @Autowired
    private FlowQueryConverter flowQueryConverter;

    @Override
    protected ModelConverter<FlowDO, Flow> getModelConverter() {
        return flowConverter;
    }

    @Override
    protected BaseDAO<FlowDO, FlowDBQuery> getDAO() {
        return flowDAO;
    }

    @Override
    protected QueryConditionConverter<FlowQuery, FlowDBQuery> getConditionConverter() {
        return flowQueryConverter;
    }
}
