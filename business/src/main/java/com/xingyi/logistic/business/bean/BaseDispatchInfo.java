package com.xingyi.logistic.business.bean;

/**
 * Created by Jadic on 2018/1/21.
 */
public class BaseDispatchInfo extends BaseModelAndDO {

    private Long customerTaskFlowId;
    private String orderNo;
    private Integer dispatchType;
    private Long shipId;
    private String shipNo;
    private Integer shipFlag;
    private Integer preWeight;
    private Integer preLoad;
    private Integer preArriveTime;
    private Double preSettleAmount;
    private Double actualTransferPrice;
    private Integer settleType;
    private Integer status;
    private Long leftDispatchId;


    public Long getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Long customerTaskFlowId) {
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

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public Integer getShipFlag() {
        return shipFlag;
    }

    public void setShipFlag(Integer shipFlag) {
        this.shipFlag = shipFlag;
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

    public Double getActualTransferPrice() {
        return actualTransferPrice;
    }

    public void setActualTransferPrice(Double actualTransferPrice) {
        this.actualTransferPrice = actualTransferPrice;
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

    public Long getLeftDispatchId() {
        return leftDispatchId;
    }

    public void setLeftDispatchId(Long leftDispatchId) {
        this.leftDispatchId = leftDispatchId;
    }
}
