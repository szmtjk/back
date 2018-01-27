package com.xingyi.logistic.qiangdan.service.impl;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.AppUserQueryConverter;
import com.xingyi.logistic.qiangdan.db.dao.AppUserDAO;
import com.xingyi.logistic.qiangdan.db.entity.AppUserDBQuery;
import com.xingyi.logistic.qiangdan.db.entity.AppUserDO;
import com.xingyi.logistic.qiangdan.model.AppUser;
import com.xingyi.logistic.qiangdan.model.AppUserQuery;
import com.xingyi.logistic.qiangdan.service.AppUserService;
import com.xingyi.logistic.qiangdan.service.converter.AppUserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl extends BaseCRUDService<AppUserDO,AppUser,AppUserDBQuery,AppUserQuery> implements AppUserService{
    @Autowired
    private AppUserDAO appUserDAO;

    @Autowired
    private AppUserConverter appUserConverter;

    @Autowired
    private AppUserQueryConverter appUserQueryConverter;

    @Override
    protected ModelConverter<AppUserDO, AppUser> getModelConverter() {
        return this.appUserConverter;
    }

    @Override
    protected BaseDAO<AppUserDO, AppUserDBQuery> getDAO() {
        return this.appUserDAO;
    }

    @Override
    protected QueryConditionConverter<AppUserQuery, AppUserDBQuery> getConditionConverter() {
        return this.appUserQueryConverter;
    }
}
