package com.szmtjk.business.bean;


import com.szmtjk.business.bean.base.BaseModelAndDO;

/**
 * 三方基础信息
 */
public class BaseUserThirdPartyDetail extends BaseModelAndDO {

    private Integer thirdType;
    private String thirdId;
    private Integer appType;
    private String thirdId2;
    private String extra;

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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
