package com.szmtjk.authentication.oauth.weixin.service.impl;

import com.alibaba.fastjson.JSON;
import com.szmtjk.authentication.oauth.weixin.dto.CommonResult;
import com.szmtjk.authentication.oauth.weixin.dto.TokenResult;
import com.szmtjk.authentication.oauth.weixin.dto.UserInfoResult;
import com.szmtjk.authentication.oauth.weixin.service.WeiXinService;
import com.szmtjk.authentication.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author 16101934
 * @time 2018/1/27 19:01
 */
@Service
public class WeiXinServiceImpl implements WeiXinService {
    @Value("${oauth.weixin.appId}")
    private String appId;

    @Value("${oauth.weixin.secretKey}")
    private String secretKey;

    @Override
    public TokenResult getToken(String code) {
        String uri = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code&appid="+ this.appId +"&secret="+ this.secretKey +"&code=" + code;
        String result = HttpClientUtil.doGet(uri);
        TokenResult tokenResult = JSON.parseObject(result,TokenResult.class);
        return tokenResult;
    }

    @Override
    public TokenResult refreshToken(String refreshToken) {
        String uri = "https://api.weixin.qq.com/sns/oauth2/refresh_token?grant_type=refresh_token&appid="+ this.appId +"&refresh_token="+ refreshToken;
        String result = HttpClientUtil.doGet(uri);
        TokenResult tokenResult = JSON.parseObject(result,TokenResult.class);
        return tokenResult;
    }

    @Override
    public Boolean isValidToken(String accessToken,String openId) {
        String uri = "https://api.weixin.qq.com/sns/auth?access_token="+ accessToken +"&openid="+ openId;
        String result = HttpClientUtil.doGet(uri);
        CommonResult commonResult = JSON.parseObject(result,CommonResult.class);
        return commonResult.isSuccess();
    }

    @Override
    public UserInfoResult getUserInfo(String accessToken, String openId) {
        String uri = "https://api.weixin.qq.com/sns/userinfo?access_token="+ accessToken +"&openid="+ openId;
        String result = HttpClientUtil.doGet(uri);
        UserInfoResult userInfoResult = JSON.parseObject(result,UserInfoResult.class);
        return userInfoResult;
    }
}
