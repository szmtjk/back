package com.xingyi.logistic.authentication.bean;

import com.xingyi.logistic.business.bean.BaseModelAndDO;

public class BaseOAuth extends BaseModelAndDO {
    private Integer userId;
    private String oauthName;
    private String oauthId;
    private String accessToken;
    private String oauthExpires;
    private Integer isDeleted;

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOauthName() {
        return oauthName;
    }

    public void setOauthName(String oauthName) {
        this.oauthName = oauthName;
    }

    public String getOauthId() {
        return oauthId;
    }

    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getOauthExpires() {
        return oauthExpires;
    }

    public void setOauthExpires(String oauthExpires) {
        this.oauthExpires = oauthExpires;
    }
}
