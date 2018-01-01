package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.PortDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.model.Port;
import com.xingyi.logistic.business.model.PortQuery;
import com.xingyi.logistic.business.service.PortService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.PortConverter;
import com.xingyi.logistic.business.service.converter.PortQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class PortServiceImpl extends BaseCRUDService<PortDO, Port, PortDBQuery, PortQuery> implements PortService {

    @Autowired
    private PortDAO portDAO;

    @Autowired
    private PortConverter portConverter;

    @Autowired
    private PortQueryConverter portQueryConverter;

    @Override
    protected ModelConverter<PortDO, Port> getModelConverter() {
        return portConverter;
    }

    @Override
    protected BaseDAO<PortDO, PortDBQuery> getDAO() {
        return portDAO;
    }

    @Override
    protected QueryConditionConverter<PortQuery, PortDBQuery> getConditionConverter() {
        return portQueryConverter;
    }
}
