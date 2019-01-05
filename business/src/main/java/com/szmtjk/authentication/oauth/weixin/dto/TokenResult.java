package com.szmtjk.authentication.oauth.weixin.dto;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author 16101934
 * @time 2018/1/27 18:20
 */
public class TokenResult extends CommonResult {
    private String openid;
    private String access_token;
    private String refresh_token;
    private String scope;
    private Long expires_in;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this,SerializerFeature.WriteMapNullValue);
    }
}
