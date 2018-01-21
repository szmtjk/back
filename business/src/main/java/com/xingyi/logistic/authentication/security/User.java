package com.xingyi.logistic.authentication.security;

import com.xingyi.logistic.authentication.model.UserProfile;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午10:41.
 */
public class User {
	private UserProfile profile;

	public User(){

	}

	public User(UserProfile profile){
		this.profile = profile;
	}

	public UserProfile getProfile() {
		return profile;
	}

	public void setProfile(UserProfile profile) {
		this.profile = profile;
	}
}
