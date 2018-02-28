package com.xingyi.logistic.business.model;

/**
 * Created by Jadic on 2018/1/21.
 */
public class ReservationCheckFlagInfo {

    private Long id;//预约id
    private Integer preArrivePortTime;//预计到港时间
    private Integer preLoad;//预报吨位
    private Integer preActualLoad;//预发吨位
    private Double actualTransferPrice;//实际运价
    private Double preSettleAmount;//预结算金额
    private Integer settleType;//结算方式
    private Long leftDispatchId;//余量临调id
    private Long dispatchId;//修改时关联的调度计划id
    private Long customerTaskFlowId;//客户流向id
    private Integer checkStatus;//数据标识  0:待审核  1:审核通过  2:审核不通过

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPreArrivePortTime() {
        return preArrivePortTime;
    }

    public void setPreArrivePortTime(Integer preArrivePortTime) {
        this.preArrivePortTime = preArrivePortTime;
    }

    public Integer getPreLoad() {
        return preLoad;
    }

    public void setPreLoad(Integer preLoad) {
        this.preLoad = preLoad;
    }

    public Integer getPreActualLoad() {
        return preActualLoad;
    }

    public void setPreActualLoad(Integer preActualLoad) {
        this.preActualLoad = preActualLoad;
    }

    public Double getActualTransferPrice() {
        return actualTransferPrice;
    }

    public void setActualTransferPrice(Double actualTransferPrice) {
        this.actualTransferPrice = actualTransferPrice;
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

    public Long getLeftDispatchId() {
        return leftDispatchId;
    }

    public void setLeftDispatchId(Long leftDispatchId) {
        this.leftDispatchId = leftDispatchId;
    }

    public Long getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Long dispatchId) {
        this.dispatchId = dispatchId;
    }

    public Long getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Long customerTaskFlowId) {
        this.customerTaskFlowId = customerTaskFlowId;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }
}
