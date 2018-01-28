package com.xingyi.logistic.authentication.bean;

import com.xingyi.logistic.business.bean.BaseModelAndDO;

public class BaseOAuth extends BaseModelAndDO {
    private Long userId;
    private String oauthName;
    private String oauthId;
    private String accessToken;
    private String refreshToken;
    private String unionId;
    private String scope;
    private Long oauthExpires;
    private Integer isDeleted;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
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

    public Long getOauthExpires() {
        return oauthExpires;
    }

    public void setOauthExpires(Long oauthExpires) {
        this.oauthExpires = oauthExpires;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
