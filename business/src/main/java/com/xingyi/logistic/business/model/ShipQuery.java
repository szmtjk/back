package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

import java.util.List;

/**
 * Created by Jadic on 2017/12/31.
 */
public class ShipQuery extends BaseQueryPage {
    private String key;
    private Integer customerTaskFlowId;
    private List<Integer> shipFlags;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Integer customerTaskFlowId) {
        this.customerTaskFlowId = customerTaskFlowId;
    }

    public List<Integer> getShipFlags() {
        return shipFlags;
    }

    public void setShipFlags(List<Integer> shipFlags) {
        this.shipFlags = shipFlags;
    }
}
