package com.xingyi.logistic.authentication.authenticator.impl;

import com.xingyi.logistic.authentication.authenticator.Authenticator;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午3:01.
 */
public class OAuthAuthenticator implements Authenticator {
	@Override
	public JsonRet<Object> authenticate(String token) {
		return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());
	}
}
