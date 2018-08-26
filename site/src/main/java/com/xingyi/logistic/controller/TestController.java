package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.aop.annotation.Operation;
import com.xingyi.logistic.business.util.JPushClientUtil;
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
@Biz("测试")
public class TestController extends BaseController {


    @Value("${aa.bb}")
    private String test;

    @Operation("hi2")
    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String testHi2() {
        return test;
    }

    @Operation
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

    @RequestMapping(value = "sendToRegistrationId", method = RequestMethod.POST)
    public String sendToRegistrationId(String registrationId, String notificationTitle, String msgTitle, String msgContent, String extrasParam) {
        long now = System.currentTimeMillis();
        int ret = JPushClientUtil.sendToRegistrationId(registrationId, notificationTitle, msgTitle, msgContent, extrasParam);
        return "sendToRegistrationId ret:" + ret;
    }
    @RequestMapping(value = "sendToAllAndroid", method = RequestMethod.POST)
    public String sendToAllAndroid(String notificationTitle, String msgTitle, String msgContent, String extrasParam) {
        return "sendToAllAndroid ret:" + JPushClientUtil.sendToAllAndroid(notificationTitle, msgTitle, msgContent, extrasParam);
    }
    @RequestMapping(value = "sendToAllIos", method = RequestMethod.POST)
    public String sendToAllIos(String notificationTitle, String msgTitle, String msgContent, String extrasParam) {
        return "sendToAllIos ret:" + JPushClientUtil.sendToAllIos(notificationTitle, msgTitle, msgContent, extrasParam);
    }
    @RequestMapping(value = "sendToAll", method = RequestMethod.POST)
    public String sendToAll(String notificationTitle, String msgTitle, String msgContent, String extrasParam) {
        return "sendToAll ret:" + JPushClientUtil.sendToAll(notificationTitle, msgTitle, msgContent, extrasParam);
    }
    @RequestMapping(value = "sendToAliasUser", method = RequestMethod.POST)
    public String sendToAliasUser(String notificationTitle, String msgTitle, String msgContent, String extrasParam, String alias) {
        return "sendToAliasUser ret:" + JPushClientUtil.sendToAliasUser(notificationTitle, msgTitle, msgContent, extrasParam, alias);
    }
}
