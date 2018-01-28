package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.CustomerTaskFlowDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDO;
import com.xingyi.logistic.business.model.CustomerTaskFlow;
import com.xingyi.logistic.business.model.CustomerTaskFlowQuery;
import com.xingyi.logistic.business.service.CustomerTaskFlowService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.CustomerTaskFlowConverter;
import com.xingyi.logistic.business.service.converter.CustomerTaskFlowQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 客户任务流向
 */
@Service
public class CustomerTaskFlowServiceImpl extends BaseCRUDService<CustomerTaskFlowDO, CustomerTaskFlow, CustomerTaskFlowDBQuery, CustomerTaskFlowQuery> implements CustomerTaskFlowService {

    @Autowired
    private CustomerTaskFlowDAO customerTaskFlowDAO;

    @Autowired
    private CustomerTaskFlowConverter customerTaskFlowConverter;

    @Autowired
    private CustomerTaskFlowQueryConverter customerTaskFlowQueryConverter;

    @Override
    protected ModelConverter<CustomerTaskFlowDO, CustomerTaskFlow> getModelConverter() {
        return customerTaskFlowConverter;
    }

    @Override
    protected BaseDAO<CustomerTaskFlowDO, CustomerTaskFlowDBQuery> getDAO() {
        return customerTaskFlowDAO;
    }

    @Override
    protected QueryConditionConverter<CustomerTaskFlowQuery, CustomerTaskFlowDBQuery> getConditionConverter() {
        return customerTaskFlowQueryConverter;
    }
}