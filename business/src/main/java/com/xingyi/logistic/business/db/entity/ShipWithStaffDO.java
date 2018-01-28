package com.xingyi.logistic.business.db.entity;

/**
 * Created by Jadic on 2018/1/23.
 */
public class ShipWithStaffDO extends ShipDO {

    private String captain;
    private String mobile;

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
