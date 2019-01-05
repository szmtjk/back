package com.szmtjk.authentication.authenticator;

import com.xxx.common.bean.JsonRet;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午2:51.
 */
public interface Authenticator {
	/**
	 * 认证方法
	 * @param token
	 * @return
	 */
	JsonRet<Object> authenticate(String token);
}
