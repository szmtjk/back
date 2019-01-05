package com.szmtjk.business.service;

import com.xxx.common.bean.JsonRet;

/**
 * Created by xiaohu on 2018/11/2.
 */
public interface WeChatBindService {

    JsonRet<Object> checkBind(String code, int appType);

    JsonRet<Object> bindFromMP(String code, String userName, String userPass);

    JsonRet<Object> unbindFromMP(String code);

    JsonRet<Object> sendTestMPMsg(String userName);

    JsonRet<Object> sendTestMPMsg(Long userId, String testFirst, String testRemark);
}
