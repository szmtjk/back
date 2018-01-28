package com.xingyi.logistic.authentication.service.impl;

import com.xingyi.logistic.authentication.db.dao.LocalAuthDAO;
import com.xingyi.logistic.authentication.db.entity.LocalAuthDBQuery;
import com.xingyi.logistic.authentication.db.entity.LocalAuthDO;
import com.xingyi.logistic.authentication.model.LocalAuth;
import com.xingyi.logistic.authentication.model.LocalAuthQuery;
import com.xingyi.logistic.authentication.service.LocalAuthService;
import com.xingyi.logistic.authentication.service.converter.LocalAuthConverter;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.LocalAuthQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalAuthServiceImpl extends BaseCRUDService<LocalAuthDO,LocalAuth,LocalAuthDBQuery,LocalAuthQuery> implements LocalAuthService {

    @Autowired
    private LocalAuthDAO localAuthDAO;

    @Autowired
    private LocalAuthConverter localAuthConverter;

    @Autowired
    private LocalAuthQueryConverter localAuthQueryConverter;

    @Override
    protected ModelConverter<LocalAuthDO, LocalAuth> getModelConverter() {
        return this.localAuthConverter;
    }

    @Override
    protected BaseDAO<LocalAuthDO, LocalAuthDBQuery> getDAO() {
        return this.localAuthDAO;
    }

    @Override
    protected QueryConditionConverter<LocalAuthQuery, LocalAuthDBQuery> getConditionConverter() {
        return this.localAuthQueryConverter;
    }

    @Override
    public LocalAuth queryByUserId(Long userId) {
        LocalAuthDO localAuthDO = this.localAuthDAO.queryByUserId(userId);
        LocalAuth localAuth = this.localAuthConverter.toModel(localAuthDO);
        return localAuth;
    }
}
