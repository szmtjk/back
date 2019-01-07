package com.szmtjk.business.service;

import com.xxx.common.bean.JsonRet;

/**
 * Created by xiaohu on 2019/1/7.
 */
public interface MobileService {

    JsonRet<Object> sendSMSCode(String mobile);

}
