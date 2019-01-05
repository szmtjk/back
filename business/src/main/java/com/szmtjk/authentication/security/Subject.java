package com.szmtjk.authentication.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.szmtjk.qiangdan.model.AppUser;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午10:54.
 */
public class Subject {
	private User user;
	private AppUser appUser;
	boolean isAuthenticated;

	public Subject(){

	}

	public Subject(User user){
		this.user = user;
	}

	public Subject(AppUser appUser){
		this.appUser = appUser;
	}

	public Subject(User user,boolean isAuthenticated){
		this(user);
		this.isAuthenticated = isAuthenticated;
	}


	public Subject(AppUser appUser,boolean isAuthenticated){
		this(appUser);
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

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
	}
}
