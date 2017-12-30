package com.xingyi.logistic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.ErrorPageFilter;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Jadic on 2017/6/7.
 */
public class Application extends SpringBootServletInitializer {

    /**
     * gradle bootRun的时候会找有main方法的类，如果有多个就必须在build.gradle里面指定是哪个类
     */
    public static void main(String... args) {
        SpringApplication.run(MycWebConfig.class, args);
    }

    @Override
    protected WebApplicationContext run(SpringApplication application) {
        application.getSources().remove(ErrorPageFilter.class);
        return super.run(application);
    }

    /**
     * 继承{@link SpringBootServletInitializer SpringBootServletInitializer}是通过war包来部署的入口
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MycWebConfig.class);
    }
}
