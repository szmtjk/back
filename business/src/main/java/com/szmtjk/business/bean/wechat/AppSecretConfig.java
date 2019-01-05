package com.szmtjk.business.bean.wechat;

/**
 * Created by xiaohu on 2018/11/3.
 */
public class AppSecretConfig {

    private int appType;

    private String appId;

    private String appSecret;

    public int getAppType() {
        return appType;
    }

    public void setAppType(int appType) {
        this.appType = appType;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
}
