package com.xingyi.logistic.business.model;

/**
 * Created by Jadic on 2018/1/21.
 */
public class ReservationCheckFlagInfo {

    private Integer id;//预约id
    private Integer preArrivePortTime;//预计到港时间
    private Integer preLoad;//预报吨位
    private Integer preActualLoad;//预发吨位
    private Double actualTransferPrice;//实际运价
    private Double preSettleAmount;//预结算金额
    private Integer settleType;//结算方式
    private Integer leftDispatchId;//余量临调id
    private Integer dispatchId;//修改时关联的调度计划id
    private Integer customerTaskFlowId;//客户流向id
    private Integer flag;//数据标识  1：修改  2：删除  3:新增

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Integer dispatchId) {
        this.dispatchId = dispatchId;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Integer customerTaskFlowId) {
        this.customerTaskFlowId = customerTaskFlowId;
    }

    public Integer getLeftDispatchId() {
        return leftDispatchId;
    }

    public void setLeftDispatchId(Integer leftDispatchId) {
        this.leftDispatchId = leftDispatchId;
    }
}
