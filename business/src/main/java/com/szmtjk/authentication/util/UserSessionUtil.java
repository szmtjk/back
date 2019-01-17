package com.szmtjk.authentication.util;

import com.szmtjk.business.model.User;

public class UserSessionUtil {

    private static ThreadLocal<User> currentUser = new ThreadLocal<>();

    public static void setCurrentUser(User user) {
        currentUser.set(user);
    }

    public static User getCurrentUser() {
        return currentUser.get();
    }

    public static void removeCurrentUser() {
        currentUser.remove();
    }
}
