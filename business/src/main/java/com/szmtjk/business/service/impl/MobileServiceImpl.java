package com.szmtjk.business.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.szmtjk.business.service.MobileService;
import com.szmtjk.business.util.SMSCodeCache;
import com.szmtjk.business.util.SMSUtil;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by xiaohu on 2019/1/7.
 */
@Service
public class MobileServiceImpl implements MobileService {

    private static final Logger LOG = LoggerFactory.getLogger(MobileServiceImpl.class);

    @Autowired
    private SMSCodeCache smsCodeCache;

    @Override
    public JsonRet<Object> sendSMSCode(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            return JsonRet.getErrRet(ErrCode.MOBILE_INVALID);
        }
        if (!SMSUtil.isValidMobile(mobile)) {
            return JsonRet.getErrRet(ErrCode.MOBILE_INVALID);
        }

        // 生成4位验证码
        String smsCode = SMSUtil.generateSMSCode(4);

        // 发送验证码
        try {
            boolean isSuccess = SMSUtil.sendSMS(mobile, smsCode);
            if (isSuccess) {
                cacheSMSCode(mobile, smsCode);
            }
            return JsonRet.getSuccessRet(isSuccess);
        } catch (ClientException e) {
            LOG.error("send SMS err, mobile:{}", mobile, e);
            return JsonRet.getErrRet(ErrCode.SEND_SMS_ERR);
        }
    }

    /**
     * 缓存短信验证码
     * @param mobile
     * @param smsCode
     * @return
     */
    private boolean cacheSMSCode(String mobile, String smsCode) {
        smsCodeCache.putSMSCode(mobile, smsCode);
        return true;
    }

}
