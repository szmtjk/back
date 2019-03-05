package com.szmtjk.authentication.authenticator;

import com.xxx.common.bean.JsonRet;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午2:51.
 */
public interface Authenticator {

	/**
	 * 微信用户
	 */
	int USER_TYPE_WE_CHAT = 1;

	/**
	 * web管理用户
	 */
	int USER_TYPE_WEB_USER = 2;
	/**
	 * 认证方法
	 * @param token
	 * @return
	 */
	JsonRet<Object> authenticate(String token);

	int getUserType();
}
