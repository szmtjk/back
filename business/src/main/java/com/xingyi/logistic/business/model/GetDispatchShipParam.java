package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

import javax.validation.constraints.NotNull;

/**
 * Created by Jadic on 2018/1/22.
 */
public class GetDispatchShipParam extends BaseQueryPage {
    @NotNull
    private Integer customerTaskFlowId;
    private String shipNo;
    private String shipFlag;

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

    public String getShipFlag() {
        return shipFlag;
    }

    public void setShipFlag(String shipFlag) {
        this.shipFlag = shipFlag;
    }
}
