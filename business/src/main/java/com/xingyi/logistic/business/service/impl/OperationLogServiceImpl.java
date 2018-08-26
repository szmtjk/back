package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.OperationLogDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.OperationLogDBQuery;
import com.xingyi.logistic.business.db.entity.OperationLogDO;
import com.xingyi.logistic.business.model.OperationLog;
import com.xingyi.logistic.business.model.OperationLogQuery;
import com.xingyi.logistic.business.service.OperationLogService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.OperationLogConverter;
import com.xingyi.logistic.business.service.converter.OperationLogQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaohu on 2018/8/25.
 */
@Service
public class OperationLogServiceImpl extends BaseCRUDService<OperationLogDO, OperationLog, OperationLogDBQuery, OperationLogQuery> implements OperationLogService {

    @Autowired
    private OperationLogDAO operationLogDAO;

    @Autowired
    private OperationLogConverter operationLogConverter;

    @Autowired
    private OperationLogQueryConverter operationLogQueryConverter;

    @Override
    protected ModelConverter<OperationLogDO, OperationLog> getModelConverter() {
        return operationLogConverter;
    }

    @Override
    protected BaseDAO<OperationLogDO, OperationLogDBQuery> getDAO() {
        return operationLogDAO;
    }

    @Override
    protected QueryConditionConverter<OperationLogQuery, OperationLogDBQuery> getConditionConverter() {
        return operationLogQueryConverter;
    }
}
