package com.xingyi.logistic.authentication.authenticator.impl;

import com.xingyi.logistic.authentication.authenticator.Authenticator;
import com.xingyi.logistic.authentication.service.OAuthService;
import com.xingyi.logistic.authentication.util.ApplicationContextUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.service.AppUserService;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午3:01.
 */
public class OAuthAuthenticator implements Authenticator {
	private AppUserService appUserService;
	private OAuthService oAuthService;

	public OAuthAuthenticator(){
		this.appUserService = (AppUserService) ApplicationContextUtil.getBean("appUserServiceImpl");
		this.oAuthService = (OAuthService) ApplicationContextUtil.getBean("oauthServiceImpl");
	}
	@Override
	public JsonRet<Object> authenticate(String token) {
		JsonRet<Object> jsonRet = JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());

		String[] tokenMembers = token.split(":");
		long userId = Long.valueOf(tokenMembers[0]);
		String md5 = tokenMembers[1];
		long expire = Long.valueOf(tokenMembers[2]);

		return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());
	}
}
