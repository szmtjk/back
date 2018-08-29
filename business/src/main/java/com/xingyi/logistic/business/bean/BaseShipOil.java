package com.xingyi.logistic.business.bean;


import com.xingyi.logistic.common.annotation.AllowedNumber;

/**
 * 船舶加油管理
 */
public class BaseShipOil extends BaseModelAndDO {

    private Float fuelQuantity;//实际加油量
    private Float unitPrice;//油的单价
    private Long refuelingTime;//实际加油时间

    private String disId;//调度单号
    private String shipId;
    @AllowedNumber(values = {0, 1, 2})
    private Integer status;// 扣款类型：预扣/实扣
    private String description;//备注

    private Float preAmountTotal;

    private Float actualAmountTotal;

    private Float leftAmountTotal;

    public Float getPreAmountTotal() {
        return preAmountTotal;
    }

    public Float getActualAmountTotal() {
        return actualAmountTotal;
    }

    public Float getLeftAmountTotal() {
        return leftAmountTotal;
    }

    public void setPreAmountTotal(Float preAmountTotal) {
        this.preAmountTotal = preAmountTotal;
    }

    public void setActualAmountTotal(Float actualAmountTotal) {
        this.actualAmountTotal = actualAmountTotal;
    }

    public void setLeftAmountTotal(Float leftAmountTotal) {
        this.leftAmountTotal = leftAmountTotal;
    }

    public String getDisId() {
        return disId;
    }

    public void setDisId(String disId) {
        this.disId = disId;
    }

    public Float getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(Float fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getRefuelingTime() {
        return refuelingTime;
    }

    public void setRefuelingTime(Long refuelingTime) {
        this.refuelingTime = refuelingTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
