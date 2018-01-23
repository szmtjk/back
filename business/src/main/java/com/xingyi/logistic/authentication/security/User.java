package com.xingyi.logistic.authentication.security;

import com.xingyi.logistic.authentication.model.ActionResources;
import com.xingyi.logistic.authentication.model.Roles;
import com.xingyi.logistic.authentication.model.UserProfile;

import java.util.List;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午10:41.
 */
public class User {
	private UserProfile profile;
	private List<Roles> roles;
	private List<ActionResources> resources;

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

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public List<ActionResources> getResources() {
		return resources;
	}

	public void setResources(List<ActionResources> resources) {
		this.resources = resources;
	}
}
