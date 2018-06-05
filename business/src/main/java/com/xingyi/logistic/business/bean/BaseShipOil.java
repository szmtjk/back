package com.xingyi.logistic.business.bean;


import com.xingyi.logistic.common.annotation.AllowedNumber;

/**
 * 船舶加油管理
 */
public class BaseShipOil extends BaseModelAndDO {

    private String fuelQuantity;//实际加油量
    private String unitPrice;//油的单价
    private Long refuelingTime;//实际加油时间
    private String shipId;
    @AllowedNumber(values = {0, 1, 2})
    private Integer status;// 扣款类型：预扣/实扣
    private String description;//备注

    public String getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(String fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
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
