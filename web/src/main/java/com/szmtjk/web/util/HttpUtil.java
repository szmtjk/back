package com.szmtjk.web.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author weifuping
 * @created 2016/7/29
 */
public final class HttpUtil {

    public static final String LOGIN_USER = "LOGIN_USER";

    public static HttpServletRequest getRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        return ((ServletRequestAttributes)requestAttributes).getRequest();
    }

    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    public static boolean isUserLogined() {
        return getSession().getAttribute(LOGIN_USER) != null;
    }

    public static void addLoginUser(String userName) {
        getSession().setMaxInactiveInterval(6 * 60 * 60);//6小时失效
        getSession().setAttribute(LOGIN_USER, userName);
    }

    public static void removeLoginUser() {
        getSession().removeAttribute(LOGIN_USER);
    }
}
