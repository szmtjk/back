package com.xingyi.logistic.authentication.util;

import com.xingyi.logistic.authentication.security.SecuritySession;
import com.xingyi.logistic.authentication.security.Subject;

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

	public static Subject getSubject(){
		return getSession().getSubject();
	}
}
