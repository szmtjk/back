package com.xingyi.logistic.business.db.entity;

/**
 * Created by Jadic on 2018/1/23.
 */
public class ShipWithStaffDO extends ShipDO {

    private String captain;
    private String combineMobile;

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getCombineMobile() {
        return combineMobile;
    }

    public void setCombineMobile(String combineMobile) {
        this.combineMobile = combineMobile;
    }
}
