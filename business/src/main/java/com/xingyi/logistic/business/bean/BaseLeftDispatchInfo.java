package com.xingyi.logistic.business.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

public class BaseLeftDispatchInfo extends BaseModelAndDO{

    @NotNullEmpty
    private String leftdispatchid;

    /**
     * 客户任务流向ID
     */
    @NotNullEmpty
    private Integer customerTaksFlowId;

    @NotNullEmpty
    private String goodsname;

    /**
     * 调度吨位
     */
    @NotNullEmpty
    private Integer dispatchWeight;

    @NotNullEmpty
    private Integer startportid;

    @NotNullEmpty
    private Integer startportname;

    @NotNullEmpty
    private Integer endportid;

    @NotNullEmpty
    private String endportname;

    @NotNullEmpty
    private Integer loadingTime;

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
    @NotNullEmpty
    private String specialTip;

    /**
     * 最小船舶吨位
     */
    @NotNullEmpty
    private Integer minShipWeight;

    /**
     * 最大船舶吨位
     */
    @NotNullEmpty
    private Integer maxShipWeight;

    @NotNullEmpty
    private Integer maxshipnum;

    /**
     * 水位
     */
    @NotNullEmpty
    private float waterLevel;

    /**
     * 发布状态  1：待发布  2：已发布  3：已取消
     */
    @AllowedNumber(values = {1, 2, 3}, message = "状态码错误")
    private Integer status;

    /**
     * 是否已删除
     */
    private Integer isDeleted;

    public String getLeftdispatchid() {
        return leftdispatchid;
    }

    public void setLeftdispatchid(String leftdispatchid) {
        this.leftdispatchid = leftdispatchid;
    }

    public Integer getCustomerTaksFlowId() {
        return customerTaksFlowId;
    }

    public void setCustomerTaksFlowId(Integer customerTaksFlowId) {
        this.customerTaksFlowId = customerTaksFlowId;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getDispatchWeight() {
        return dispatchWeight;
    }

    public void setDispatchWeight(Integer dispatchWeight) {
        this.dispatchWeight = dispatchWeight;
    }

    public Integer getStartportid() {
        return startportid;
    }

    public void setStartportid(Integer startportid) {
        this.startportid = startportid;
    }

    public Integer getStartportname() {
        return startportname;
    }

    public void setStartportname(Integer startportname) {
        this.startportname = startportname;
    }

    public Integer getEndportid() {
        return endportid;
    }

    public void setEndportid(Integer endportid) {
        this.endportid = endportid;
    }

    public String getEndportname() {
        return endportname;
    }

    public void setEndportname(String endportname) {
        this.endportname = endportname;
    }

    public Integer getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(Integer loadingTime) {
        this.loadingTime = loadingTime;
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

    public Integer getMaxshipnum() {
        return maxshipnum;
    }

    public void setMaxshipnum(Integer maxshipnum) {
        this.maxshipnum = maxshipnum;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}
