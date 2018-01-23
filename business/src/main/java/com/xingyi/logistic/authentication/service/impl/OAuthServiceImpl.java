package com.xingyi.logistic.authentication.service.impl;

import com.xingyi.logistic.authentication.db.dao.OAuthDAO;
import com.xingyi.logistic.authentication.db.entity.OAuthDBQuery;
import com.xingyi.logistic.authentication.db.entity.OAuthDO;
import com.xingyi.logistic.authentication.model.OAuth;
import com.xingyi.logistic.authentication.model.OAuthQuery;
import com.xingyi.logistic.authentication.service.OAuthService;
import com.xingyi.logistic.authentication.service.converter.OAuthConverter;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.OAuthQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuthServiceImpl extends BaseCRUDService<OAuthDO,OAuth,OAuthDBQuery,OAuthQuery> implements OAuthService {

    @Autowired
    private OAuthDAO oAuthDAO;

    @Autowired
    private OAuthConverter oAuthConverter;

    @Autowired
    private OAuthQueryConverter oAuthQueryConverter;

    @Override
    protected ModelConverter<OAuthDO, OAuth> getModelConverter() {
        return this.oAuthConverter;
    }

    @Override
    protected BaseDAO<OAuthDO, OAuthDBQuery> getDAO() {
        return this.oAuthDAO;
    }

    @Override
    protected QueryConditionConverter<OAuthQuery, OAuthDBQuery> getConditionConverter() {
        return this.oAuthQueryConverter;
    }
}
