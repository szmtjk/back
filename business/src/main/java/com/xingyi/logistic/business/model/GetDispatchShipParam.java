package com.xingyi.logistic.business.model;

import javax.validation.constraints.NotNull;

/**
 * Created by Jadic on 2018/1/22.
 */
public class GetDispatchShipParam {
    @NotNull
    private Integer customerTaskFlowId;
    private String shipNo;
    private String shipType;

    public Integer getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Integer customerTaskFlowId) {
        this.customerTaskFlowId = customerTaskFlowId;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }
}
