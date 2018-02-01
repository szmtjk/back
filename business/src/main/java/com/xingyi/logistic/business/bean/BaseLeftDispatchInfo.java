package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.validation.constraints.NotNull;

public class BaseLeftDispatchInfo extends BaseModelAndDO{

    /**
     * 客户任务流向ID
     */
    @NotNull
    private Integer customerTaskFlowId;

    /**
     * 调度吨位
     */
    @NotNullEmpty
    private Integer dispatchWeight;

    /**
     * 预约抢单有效开始日期
     */
    @NotNullEmpty
    private String bookSTime;

    /**
     * 预约抢单有效截止日期
     */
    @NotNullEmpty
    private String bookETime;

    /**
     * 特殊要求
     */
    private String specialTip;

    /**
     * 最小船舶吨位
     */
    @NotNull
    private Integer minShipWeight;

    /**
     * 最大船舶吨位
     */
    @NotNull
    private Integer maxShipWeight;

    @NotNull
    private Integer maxShipNum;

    /**
     * 水位
     */
    private float waterLevel;

    /**
     * 发布状态  1：待发布  2：已发布  3：已取消
     */
    @AllowedNumber(values = {1, 2, 3}, message = "状态码错误")
    private Integer status;

    private Integer taskStatus;

    private Integer isDeleted;

    private String goodsName;
    private String startPortName;
    private String endPortName;
    private String customerName;
    private String flowName;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getStartPortName() {
        return startPortName;
    }

    public void setStartPortName(String startPortName) {
        this.startPortName = startPortName;
    }

    public String getEndPortName() {
        return endPortName;
    }

    public void setEndPortName(String endPortName) {
        this.endPortName = endPortName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Integer customerTaskFlowId) {
        this.customerTaskFlowId = customerTaskFlowId;
    }

    public Integer getDispatchWeight() {
        return dispatchWeight;
    }

    public void setDispatchWeight(Integer dispatchWeight) {
        this.dispatchWeight = dispatchWeight;
    }

    public String getBookSTime() {
        return bookSTime;
    }

    public void setBookSTime(String bookSTime) {
        this.bookSTime = bookSTime;
    }

    public String getBookETime() {
        return bookETime;
    }

    public void setBookETime(String bookETime) {
        this.bookETime = bookETime;
    }

    public String getSpecialTip() {
        return specialTip;
    }

    public void setSpecialTip(String specialTip) {
        this.specialTip = specialTip;
    }

    public Integer getMinShipWeight() {
        return minShipWeight;
    }

    public void setMinShipWeight(Integer minShipWeight) {
        this.minShipWeight = minShipWeight;
    }

    public Integer getMaxShipWeight() {
        return maxShipWeight;
    }

    public void setMaxShipWeight(Integer maxShipWeight) {
        this.maxShipWeight = maxShipWeight;
    }

    public Integer getMaxShipNum() {
        return maxShipNum;
    }

    public void setMaxShipNum(Integer maxShipNum) {
        this.maxShipNum = maxShipNum;
    }

    public float getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(float waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }
}
