package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

public class BaseFreightPlan extends BaseModelAndDO {

    @NotNullEmpty
    @AllowedNumber(values = {1, 2, 3}, message = "船舶类型错误")
    private Integer shipFlag;//船舶类型1、熟料2、散装3、集装箱

    private String time;//年月份
    private Integer revUnit;//收货单位
    private Integer goodsName;//货物名称
    private Long plan; //计划
    /**
     * 备注

     */
    private String description;

    /**
     * 是否已删除
     */
    private Integer isDeleted;

    public Integer getShipFlag() {
        return shipFlag;
    }

    public void setShipFlag(Integer shipFlag) {
        this.shipFlag = shipFlag;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getRevUnit() {
        return revUnit;
    }

    public void setRevUnit(Integer revUnit) {
        this.revUnit = revUnit;
    }

    public Integer getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(Integer goodsName) {
        this.goodsName = goodsName;
    }

    public Long getPlan() {
        return plan;
    }

    public void setPlan(Long plan) {
        this.plan = plan;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
