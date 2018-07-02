package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

/**
 * Created by Jadic on 2018/1/21.
 */
public class DispatchInfoQuery extends BaseQueryPage {

    private Integer shipId;
    private Integer customerTaskFlowId;
    private Integer settleType;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public Integer getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Integer customerTaskFlowId) {
        this.customerTaskFlowId = customerTaskFlowId;
    }

    public Integer getSettleType() {
        return settleType;
    }

    public void setSettleType(Integer settleType) {
        this.settleType = settleType;
    }
}
