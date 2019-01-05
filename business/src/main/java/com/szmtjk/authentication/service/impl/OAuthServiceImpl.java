package com.szmtjk.authentication.service.impl;

import com.szmtjk.authentication.service.converter.OAuthConverter;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.service.base.ModelConverter;
import com.szmtjk.business.service.base.QueryConditionConverter;
import com.szmtjk.business.service.converter.OAuthQueryConverter;
import com.szmtjk.authentication.db.dao.OAuthDAO;
import com.szmtjk.authentication.db.entity.OAuthDBQuery;
import com.szmtjk.authentication.db.entity.OAuthDO;
import com.szmtjk.authentication.model.OAuth;
import com.szmtjk.authentication.model.OAuthQuery;
import com.szmtjk.authentication.service.OAuthService;
import com.xxx.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "oauthServiceImpl")
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

	@Override
	public JsonRet<OAuth> save(OAuth oAuth) {
    	OAuth dbOauth = this.queryByOauthId(oAuth.getOauthId());
    	if(null != dbOauth){
    		oAuth.setId(dbOauth.getId());
    		oAuth.setUserId(dbOauth.getUserId());
		    JsonRet<Boolean> modifyRet = this.modify(oAuth);
		    if(!modifyRet.isSuccess()){
		    	return JsonRet.getErrRet(modifyRet.getErrCode(),modifyRet.getMsg());
		    }
	    }else{
		    JsonRet<Long> addRet = this.add(oAuth);
		    if(!addRet.isSuccess()){
			    return JsonRet.getErrRet(addRet.getErrCode(),addRet.getMsg());
		    }
		    Long oauthId = addRet.getData();
		    oAuth.setId(oauthId);
	    }
		return JsonRet.getSuccessRet(oAuth);
	}

	@Override
	public OAuth queryByOauthId(String oauthId) {
    	OAuth oAuth = null;
    	OAuthDO oAuthDO = this.oAuthDAO.queryByOauthId(oauthId);
    	if(null != oAuthDO){
    		oAuth = this.oAuthConverter.toModel(oAuthDO);
	    }
		return oAuth;
	}

	@Override
	public OAuth queryByAppUserId(Long appUserId) {
		OAuth oAuth = null;
		OAuthDO oAuthDO = this.oAuthDAO.queryByAppUserId(appUserId);
		if(null != oAuthDO){
			oAuth = this.oAuthConverter.toModel(oAuthDO);
		}
		return oAuth;
	}
}
