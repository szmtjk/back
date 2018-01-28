package com.xingyi.logistic.authentication.security;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午10:55.
 */
public class SecuritySession {

	private static class StaticSecuritySession{
		private static SecuritySession instance = new SecuritySession();
		private static Subject subject = null;
	}

	private SecuritySession(){

	}

	public static SecuritySession getInstance(){
		return StaticSecuritySession.instance;
	}

	public void setSubject(Subject subject){
		StaticSecuritySession.subject = subject;
	}

	public void removeSubject(){
		StaticSecuritySession.subject = null;
	}

	public Subject getSubject(){
		return StaticSecuritySession.subject;
	}
}
