package com.szmtjk.qiangdan.service.impl;

import com.szmtjk.qiangdan.db.entity.AppUserDBQuery;
import com.szmtjk.qiangdan.db.entity.AppUserDO;
import com.szmtjk.qiangdan.service.AppUserService;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.converter.base.ModelConverter;
import com.szmtjk.business.converter.base.QueryConditionConverter;
import com.szmtjk.business.service.converter.AppUserQueryConverter;
import com.szmtjk.qiangdan.db.dao.AppUserDAO;
import com.szmtjk.qiangdan.model.AppUser;
import com.szmtjk.qiangdan.model.AppUserQuery;
import com.szmtjk.qiangdan.service.converter.AppUserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl extends BaseCRUDService<AppUserDO,AppUser,AppUserDBQuery,AppUserQuery> implements AppUserService {
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
