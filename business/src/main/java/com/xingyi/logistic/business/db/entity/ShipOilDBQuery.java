package com.xingyi.logistic.business.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;


/**
 * Created by 王志方 on 2017/12/31.
 */
public class ShipOilDBQuery extends BaseDBQueryPage {
    private String key;

    private Long shipId;

    private Long disId;

    public Long getShipId() {
        return shipId;
    }

    public Long getDisId() {
        return disId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public void setDisId(Long disId) {
        this.disId = disId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


}
