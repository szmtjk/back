package com.szmtjk.authentication;

/**
 * @author 16101934
 * @time 2018/1/27 19:53
 */
public enum OAuthType {
    WEIXIN("weixin","微信");

    private String code;
    private String name;

    OAuthType(String code,String name){
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
