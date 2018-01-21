package com.xingyi.logistic.authentication.security;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午10:54.
 */
public class Subject {
	private User user;
	boolean isAuthenticated;

	public Subject(){

	}

	public Subject(User user){
		this.user = user;
	}

	public Subject(User user,boolean isAuthenticated){
		this(user);
		this.isAuthenticated = isAuthenticated;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isAuthenticated() {
		return isAuthenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		isAuthenticated = authenticated;
	}
}
