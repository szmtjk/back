package com.xingyi.logistic.authentication.util;

import com.xingyi.logistic.authentication.security.SecuritySession;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午11:26.
 */
public final class SessionUtil {

	private SessionUtil(){

	}

	public static SecuritySession getSession(){
		return SecuritySession.getInstance();
	}
}
