package com.szmtjk.business.bean.wechat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by xiaohu on 2018/10/26.
 */
public class AccessTokenResponse extends BaseResonpse {

    @JSONField(name = "access_token")
    private String accessToken;
    @JSONField(name = "expires_in")
    private int expiresIn;

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
}
