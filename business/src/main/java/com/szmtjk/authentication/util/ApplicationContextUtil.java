package com.szmtjk.authentication.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午11:39.
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if(null == ApplicationContextUtil.applicationContext){
			ApplicationContextUtil.applicationContext = applicationContext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name){
		return getApplicationContext().getBean(name);

	}

	public static <T> T getBean(Class<T> clazz){
		return getApplicationContext().getBean(clazz);
	}

	public static <T> T getBean(String name,Class<T> clazz){
		return getApplicationContext().getBean(name, clazz);
	}
}
