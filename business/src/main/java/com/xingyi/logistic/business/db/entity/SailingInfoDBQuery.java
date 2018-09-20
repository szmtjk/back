package com.xingyi.logistic.business.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;

/**
 * 航次信息
 */
public class SailingInfoDBQuery extends BaseDBQueryPage {

    private String key;

    private  String status;

    private Long orderId;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
