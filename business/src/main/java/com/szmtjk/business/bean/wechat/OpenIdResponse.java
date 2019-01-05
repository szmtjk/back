package com.szmtjk.business.bean.wechat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by xiaohu on 2018/10/26.
 */
public class OpenIdResponse extends BaseResonpse {

    @JSONField(name = "access_token")
    private String accessToken;
    @JSONField(name = "expires_in")
    private int expiresIn;
    @JSONField(name = "refresh_token")
    private String refreshToken;
    @JSONField(name = "openid")
    private String openId;
    @JSONField(name = "unionid")
    private String unionId;// 小程序接口返回
    private String scope;
    @JSONField(name = "session_key")
    private String sessionKey;// 小程序返回

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
