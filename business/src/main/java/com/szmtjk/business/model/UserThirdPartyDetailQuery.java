package com.szmtjk.business.model;

import com.szmtjk.business.bean.base.BaseQueryPage;

public class UserThirdPartyDetailQuery extends BaseQueryPage {

    private Long id;
    private String thirdId;
    private Integer thirdType;
    private Integer appType;
    private String thirdId2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public Integer getThirdType() {
        return thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public String getThirdId2() {
        return thirdId2;
    }

    public void setThirdId2(String thirdId2) {
        this.thirdId2 = thirdId2;
    }
}
