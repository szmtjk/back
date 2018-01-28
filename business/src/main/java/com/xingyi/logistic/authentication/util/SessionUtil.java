package com.xingyi.logistic.authentication.util;

import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.security.SecuritySession;
import com.xingyi.logistic.authentication.security.Subject;
import com.xingyi.logistic.authentication.security.User;
import com.xingyi.logistic.qiangdan.model.AppUser;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午11:26.
 */
public final class SessionUtil {

	private SessionUtil(){

	}

	public static SecuritySession getSession(){
		SecuritySession session = SecuritySession.getInstance();
		System.out.println(">>>>>>>>>>>>>>>>>" + SessionUtil.class.getName() + "获取SecuritySession:" + session);
		return session;
	}

	public static Subject getSubject(){
		Subject subject = getSession().getSubject();
		System.out.println(">>>>>>>>>>>>>>>>>" + SessionUtil.class.getName() + "获取subject:" + subject);
		return subject;
	}

	public static User getUser(){
		User user = getSubject().getUser();
		System.out.println(">>>>>>>>>>>>>>>>>" + SessionUtil.class.getName() + "获取user:" + user);
		return user;
	}

	public static UserProfile getProfile(){
		UserProfile profile = getUser().getProfile();
		System.out.println(">>>>>>>>>>>>>>>>>" + SessionUtil.class.getName() + "获取profile:" + profile);
	    return profile;
    }

    public static AppUser getAppUser(){
		AppUser appUser = getSubject().getAppUser();
	    System.out.println(">>>>>>>>>>>>>>>>>" + SessionUtil.class.getName() + "获取appUser:" + appUser);
	    return appUser;
    }
}
