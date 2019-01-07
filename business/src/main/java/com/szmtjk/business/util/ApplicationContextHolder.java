package com.szmtjk.business.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaohu on 2019/1/5.
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static final Logger LOG = LoggerFactory.getLogger(ApplicationContextHolder.class);

    protected static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getByName(String beanName) {
        return applicationContext.getBean(beanName);
    }

    public static Object getBean(String beanName, String possibleSuffix) {
        List<String> beanPossibleNames = new ArrayList<>();
        beanPossibleNames.add(beanName.substring(0, 1).toLowerCase() + beanName.substring(1) + possibleSuffix);//bean名称首字母小写
        beanPossibleNames.add(beanName + possibleSuffix);
        for (String beanPossibleName : beanPossibleNames) {
            try {
                Object bean = ApplicationContextHolder.getByName(beanPossibleName);
                return bean;
            } catch (Exception e) {
                LOG.warn("Bean not found, beanName:{}", beanPossibleName);
            }
        }
        LOG.error("get bean err, beanName:{}, possibleSuffix={}",
                beanName, possibleSuffix);
        return null;
    }
}