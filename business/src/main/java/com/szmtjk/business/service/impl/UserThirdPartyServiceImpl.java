package com.szmtjk.business.service.impl;

import com.szmtjk.business.db.dao.UserThirdPartyDAO;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.service.base.ModelConverter;
import com.szmtjk.business.service.base.QueryConditionConverter;
import com.szmtjk.business.db.entity.UserThirdPartyDBQuery;
import com.szmtjk.business.db.entity.UserThirdPartyDO;
import com.szmtjk.business.model.UserThirdParty;
import com.szmtjk.business.model.UserThirdPartyQuery;
import com.szmtjk.business.service.UserThirdPartyService;
import com.szmtjk.business.service.converter.UserThirdPartyConverter;
import com.szmtjk.business.service.converter.UserThirdPartyQueryConverter;
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
