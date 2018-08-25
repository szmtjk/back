package com.xingyi.logistic.business.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;

/**
 * 航次信息
 */
public class SailingInfoDBQuery extends BaseDBQueryPage {

    private String key;

    private  String status;

    private Long orderId;

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
