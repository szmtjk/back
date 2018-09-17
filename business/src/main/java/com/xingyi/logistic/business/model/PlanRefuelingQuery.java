package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

/**
 * wzf
 */
public class PlanRefuelingQuery extends BaseQueryPage {

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
