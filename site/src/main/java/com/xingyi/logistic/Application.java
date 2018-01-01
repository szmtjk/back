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

    public static void main(String... args) {
        SpringApplication.run(MycWebConfig.class, args);
    }

    @Override
    protected WebApplicationContext run(SpringApplication application) {
        application.getSources().remove(ErrorPageFilter.class);
        return super.run(application);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MycWebConfig.class);
    }
}
