package com.xingyi.logistic.authentication.security;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午10:55.
 */
public class SecuritySession {

	private static class StaticSecuritySession{
		private static SecuritySession instance = new SecuritySession();
	}

	private ThreadLocal<Subject> subjectContext = new ThreadLocal<Subject>();

	private SecuritySession(){

	}

	public static SecuritySession getInstance(){
		return StaticSecuritySession.instance;
	}

	public void setSubject(Subject subject){
		this.subjectContext.set(subject);
	}

	public void removeSubject(){
		this.subjectContext.remove();
	}

	public Subject getSubject(){
		return this.subjectContext.get();
	}
}
