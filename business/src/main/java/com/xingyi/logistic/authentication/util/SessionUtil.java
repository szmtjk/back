package com.xingyi.logistic.authentication.util;

import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.security.Subject;
import com.xingyi.logistic.authentication.security.User;
import com.xingyi.logistic.qiangdan.model.AppUser;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午11:26.
 */
public final class SessionUtil {
	private static ThreadLocal<Subject> subjectContext = new ThreadLocal<Subject>();

	private SessionUtil(){

	}

	public static User getUser(){
		User user = getSubject().getUser();
		return user;
	}

	public static UserProfile getProfile(){
		UserProfile profile = getUser().getProfile();
	    return profile;
    }

    public static AppUser getAppUser(){
		AppUser appUser = getSubject().getAppUser();
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
}
