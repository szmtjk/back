package com.szmtjk.business.db.entity;

import com.szmtjk.business.bean.BaseDBQueryPage;

/**
 * Created by xiaohu on 2018/10/28.
 */
public class UserThirdPartyDetailDBQuery extends BaseDBQueryPage {

    private Integer thirdType;
    private String thirdId;
    private Integer appType;
    private String thirdId2;

    public Integer getThirdType() {
        return thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
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
