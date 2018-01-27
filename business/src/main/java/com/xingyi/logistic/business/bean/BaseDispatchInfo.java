package com.xingyi.logistic.business.bean;

/**
 * Created by Jadic on 2018/1/21.
 */
public class BaseDispatchInfo extends BaseModelAndDO {

    private Integer customerTaskFlowId;
    private String orderNo;
    private Integer dispatchType;
    private Integer shipId;
    private Integer shipType;
    private Integer preWeight;
    private Integer preLoad;
    private Integer preArriveTime;
    private Double preSettleAmount;
    private Integer settleType;
    private Integer status;
    public Integer getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Integer customerTaskFlowId) {
        this.customerTaskFlowId = customerTaskFlowId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(Integer dispatchType) {
        this.dispatchType = dispatchType;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public Integer getShipType() {
        return shipType;
    }

    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }

    public Integer getPreWeight() {
        return preWeight;
    }

    public void setPreWeight(Integer preWeight) {
        this.preWeight = preWeight;
    }

    public Integer getPreLoad() {
        return preLoad;
    }

    public void setPreLoad(Integer preLoad) {
        this.preLoad = preLoad;
    }

    public Integer getPreArriveTime() {
        return preArriveTime;
    }

    public void setPreArriveTime(Integer preArriveTime) {
        this.preArriveTime = preArriveTime;
    }

    public Double getPreSettleAmount() {
        return preSettleAmount;
    }

    public void setPreSettleAmount(Double preSettleAmount) {
        this.preSettleAmount = preSettleAmount;
    }

    public Integer getSettleType() {
        return settleType;
    }

    public void setSettleType(Integer settleType) {
        this.settleType = settleType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
