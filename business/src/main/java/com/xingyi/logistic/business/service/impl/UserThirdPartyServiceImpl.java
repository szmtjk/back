package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.UserThirdPartyDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.UserThirdPartyDBQuery;
import com.xingyi.logistic.business.db.entity.UserThirdPartyDO;
import com.xingyi.logistic.business.model.UserThirdParty;
import com.xingyi.logistic.business.model.UserThirdPartyQuery;
import com.xingyi.logistic.business.service.UserThirdPartyService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.UserThirdPartyConverter;
import com.xingyi.logistic.business.service.converter.UserThirdPartyQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class UserThirdPartyServiceImpl extends BaseCRUDService<UserThirdPartyDO, UserThirdParty, UserThirdPartyDBQuery, UserThirdPartyQuery> implements UserThirdPartyService {
    @Autowired
    private UserThirdPartyDAO userThirdPartyDAO;

    @Autowired
    private UserThirdPartyConverter userThirdPartyConverter;

    @Autowired
    private UserThirdPartyQueryConverter userThirdPartyQueryConverter;

    @Override
    protected ModelConverter<UserThirdPartyDO, UserThirdParty> getModelConverter() {
        return userThirdPartyConverter;
    }

    @Override
    protected BaseDAO<UserThirdPartyDO, UserThirdPartyDBQuery> getDAO() {
        return userThirdPartyDAO;
    }

    @Override
    protected QueryConditionConverter<UserThirdPartyQuery, UserThirdPartyDBQuery> getConditionConverter() {
        return userThirdPartyQueryConverter;
    }
}
