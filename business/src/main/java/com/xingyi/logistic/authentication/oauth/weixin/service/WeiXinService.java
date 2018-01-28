package com.xingyi.logistic.authentication.oauth.weixin.service;

import com.xingyi.logistic.authentication.oauth.weixin.dto.TokenResult;
import com.xingyi.logistic.authentication.oauth.weixin.dto.UserInfoResult;

/**
 * @author 16101934
 * @time 2018/1/27 18:06
 */
public interface WeiXinService {
    /**
     * 获取Token
     * @param code
     * @return
     */
    TokenResult getToken(String code);

    /**
     * 刷新Token
     * @param refreshToken
     * @return
     */
    TokenResult refreshToken(String refreshToken);

    /**
     * 检验 Token 是否有效
     * @param accessToken
     * @return
     */
    Boolean isValidToken(String accessToken,String openId);

    /**
     * 获取用户信息
     * @param accessToken
     * @param openId
     * @return
     */
    UserInfoResult getUserInfo(String accessToken,String openId);
}
