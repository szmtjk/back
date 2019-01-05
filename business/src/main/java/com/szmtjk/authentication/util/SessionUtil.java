package com.szmtjk.authentication.util;

import com.szmtjk.authentication.security.Subject;
import com.szmtjk.authentication.security.User;
import com.szmtjk.qiangdan.model.AppUser;
import com.szmtjk.authentication.model.UserProfile;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午11:26.
 */
public final class SessionUtil {
	private static ThreadLocal<Subject> subjectContext = new ThreadLocal<Subject>();
	private static ThreadLocal<String> tokenContext = new ThreadLocal<String>();

	private SessionUtil(){

	}

	public static User getUser(){
		User user = null;
		Subject subject = getSubject();
		if(null != subject){
			user = subject.getUser();
		}
		return user;
	}

	public static UserProfile getProfile(){
		UserProfile profile = null;
		User user = getUser();
		if(null != user){
			profile = user.getProfile();
		}
	    return profile;
    }

    public static AppUser getAppUser(){
		AppUser appUser = null;
		Subject subject = getSubject();
		if(null != subject){
			appUser = subject.getAppUser();
		}
	    return appUser;
    }

    public static void setSubject(Subject subject){
		subjectContext.set(subject);
    }

    public static Subject getSubject(){
		return subjectContext.get();
    }

    public static void removeSubject(){
		subjectContext.remove();
    }

    public static void setToken(String token){
		tokenContext.set(token);
    }

    public static String getToken(){
		return tokenContext.get();
    }

    public static void removeToken(){
		tokenContext.remove();
    }
}
