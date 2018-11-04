package com.xingyi.logistic.business.service;

import com.xingyi.logistic.common.bean.JsonRet;

/**
 * Created by xiaohu on 2018/11/2.
 */
public interface WeChatBindService {

    JsonRet<Object> checkBind(String code, int appType);

    JsonRet<Object> bindFromMP(String code, String userName, String userPass);

}
