package com.szmtjk.authentication.service.impl;

import com.szmtjk.authentication.db.entity.LocalAuthDO;
import com.szmtjk.authentication.model.LocalAuthQuery;
import com.szmtjk.business.service.base.ModelConverter;
import com.szmtjk.business.service.base.QueryConditionConverter;
import com.szmtjk.authentication.db.dao.LocalAuthDAO;
import com.szmtjk.authentication.db.entity.LocalAuthDBQuery;
import com.szmtjk.authentication.model.LocalAuth;
import com.szmtjk.authentication.service.LocalAuthService;
import com.szmtjk.authentication.service.converter.LocalAuthConverter;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.service.converter.LocalAuthQueryConverter;
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
	    LocalAuth localAuth = null;
		LocalAuthDO localAuthDO = this.localAuthDAO.queryByUserId(userId);
		if(null != localAuthDO){
			localAuth = this.localAuthConverter.toModel(localAuthDO);
		}
        return localAuth;
    }

    @Override
    public LocalAuth queryByUserName(String userName) {
        LocalAuth localAuth = null;
        LocalAuthDO localAuthDO = this.localAuthDAO.queryByUserName(userName);
        if(null != localAuthDO){
            localAuth = this.localAuthConverter.toModel(localAuthDO);
        }
        return localAuth;
    }
}
