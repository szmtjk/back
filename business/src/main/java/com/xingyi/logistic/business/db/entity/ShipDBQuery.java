package com.xingyi.logistic.business.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;

import java.util.List;

/**
 * Created by Jadic on 2017/12/31.
 */
public class ShipDBQuery extends BaseDBQueryPage {
    private String key;
    private Integer customerTaskFlowId;
    private List<Integer> shipFlags;
    private String startTime;
    private String endTime;
    private String name;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
