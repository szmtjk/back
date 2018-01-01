package com.xingyi.logistic;

import com.xingyi.logistic.config.JsonParamArgumentResolver;
import com.xingyi.logistic.converter.MycMessageConvertor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by Jadic on 2017/6/16.
 */
@Configuration
@ComponentScan("com.xingyi.logistic")
@SpringBootApplication
public class MycWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new JsonParamArgumentResolver());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, new MycMessageConvertor());
    }
}
