package com.szmtjk.web.controller;

import com.szmtjk.business.service.MobileService;
import com.xxx.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiaohu on 2019/1/5.
 */
@Controller
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private MobileService mobileService;

    /**
     * 获取短信验证码
     * @param mobile
     * @return
     */
    @RequestMapping(value = "/sendSMSCode", method = RequestMethod.POST)
    @ResponseBody
    public JsonRet<Object> sendSMSCode(String mobile) {
        return mobileService.sendSMSCode(mobile);
    }
}
