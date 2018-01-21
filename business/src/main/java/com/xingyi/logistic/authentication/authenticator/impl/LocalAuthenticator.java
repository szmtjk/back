package com.xingyi.logistic.authentication.authenticator.impl;

import com.xingyi.logistic.authentication.authenticator.Authenticator;
import com.xingyi.logistic.authentication.model.LocalAuth;
import com.xingyi.logistic.authentication.service.LocalAuthService;
import com.xingyi.logistic.authentication.util.ApplicationContextUtil;
import com.xingyi.logistic.authentication.util.TokenUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午3:00.
 */
public class LocalAuthenticator implements Authenticator {

	private LocalAuthService localAuthService;

	public LocalAuthenticator(){
		this.localAuthService = (LocalAuthService) ApplicationContextUtil.getBean("localAuthServiceImpl");
	}

	@Override
	public JsonRet<Object> authenticate(String token) {
		JsonRet<Object> jsonRet = JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());

		String[] tokenMembers = token.split(":");
		long userId = Long.valueOf(tokenMembers[0]);
		String md5 = tokenMembers[1];
		long expire = Long.valueOf(tokenMembers[2]);

		JsonRet<LocalAuth> localAuthJsonRet = this.localAuthService.getById(userId);

		if(!localAuthJsonRet.isSuccess()){
			return jsonRet;
		}

		LocalAuth localAuth = localAuthJsonRet.getData();
		String loginName = localAuth.getLoginName();
		String localPasswd = localAuth.getPasswd();
		String realMd5 = TokenUtil.build(String.valueOf(userId),loginName,localPasswd,String.valueOf(expire));

		if(!StringUtils.equals(md5,realMd5)){
			return jsonRet;
		}
		return JsonRet.getSuccessRet(null);
	}
}
