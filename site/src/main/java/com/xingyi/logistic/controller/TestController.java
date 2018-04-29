package com.xingyi.logistic.controller;

import com.xingyi.logistic.config.JsonParam;
import com.xingyi.logistic.filter.AuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jadic on 2017/6/7.
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {


    @Value("${aa.bb}")
    private String test;

    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String testHi2() {
        return test;
    }

    @RequestMapping(value = "/changeFilterEnabled", method = RequestMethod.GET)
    public String changeFilterEnabled() {
        AuthenticationFilter.isEnabled = !AuthenticationFilter.isEnabled;
        return "Current enabled:" + AuthenticationFilter.isEnabled;
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String testHi() {
        return "hi, i'm ok 2 2";
    }

    @RequestMapping(value = "/t1", method = RequestMethod.GET)

    public String test1(@JsonParam TestBean a) {
        return a.getFlow().getName();
    }

}
