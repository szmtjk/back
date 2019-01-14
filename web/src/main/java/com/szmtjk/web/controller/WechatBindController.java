package com.szmtjk.web.controller;

import com.szmtjk.business.bean.wechat.AppType;
import com.szmtjk.business.service.WeChatBindService;
import com.xxx.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xiaohu on 2018/10/26.
 */
@Controller
@RequestMapping("/wechat")
public class WechatBindController {

    @Autowired
    private WeChatBindService weChatBindService;

    /**
     * 获取公众号绑定后台账号url地址
     * 公众号菜单固定维护一个请求链接，具体的跳转url由后台指定
     * @return
     */
    @RequestMapping("/getMPBindUrl")
    public String getMPBindUrl() {
        return "redirect:";
    }

    /**
     * 根据跳转后的页面获取的微信code，来后端校验是否已经绑定了某个后台账号，
     * 如果已经绑定了则返回已绑定的用户名，则在页面中显示绑定信息
     * 否则跳转至绑定账号的输入页面
     * @param code
     * @return
     */
    @RequestMapping(value = "/checkBind", method = RequestMethod.POST)
    @ResponseBody
    public JsonRet<Object> checkBind(String code, int appType) {
        return weChatBindService.checkBind(code, appType);
    }

    /**
     * 公众号页面校验是否绑定
     * 如果已经绑定则返回已绑定的手机号（打码），并在页面中显示绑定信息
     * 否则跳转至绑定账号的输入页面
     * @param code
     * @return
     */
    @RequestMapping(value = "/checkBindFromMP", method = RequestMethod.POST)
    @ResponseBody
    public JsonRet<Object> checkBindFromMP(String code) {
        return weChatBindService.checkBind(code, AppType.MP);
    }

    @RequestMapping(value = "/bindMobile", method = RequestMethod.POST)
    @ResponseBody
    public JsonRet<Object> bindMobile(String code, String mobile, String smsCode) {
        return weChatBindService.bindMobile(code, mobile, smsCode);
    }

    /**
     * 将当前微信账号绑定后台账号
     * @param code
     * @param userName
     * @param userPass
     * @return
     */
    @RequestMapping(value = "/bindFromMP", method = RequestMethod.POST)
    @ResponseBody
    public JsonRet<Object> bindMP(String code, String userName, String userPass) {
        return weChatBindService.bindFromMP(code, userName, userPass);
    }

    /**
     * 将当前微信账号绑定后台账号
     * @param code
     * @return
     */
    @RequestMapping(value = "/unbindFromMP", method = RequestMethod.POST)
    @ResponseBody
    public JsonRet<Object> unbindMP(String code) {
        return weChatBindService.unbindFromMP(code);
    }

    @RequestMapping(value = "/sendTestMPMsg", method = RequestMethod.POST)
    @ResponseBody
    public JsonRet<Object> sendTestMPMsg(String userName) {
        return weChatBindService.sendTestMPMsg(userName);
    }

}
