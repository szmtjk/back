package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * wzf
 */
public class BasePreBuckleOil extends BaseModelAndDO {

    private String shipId;//船号
    private String disId;//调度单号
    private Float preBuckleOil;//预扣油款
    private Long preBuckleTime;//扣款时间
    private String description;//bz
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Float getPreBuckleOil() {
        return preBuckleOil;
    }

    public void setPreBuckleOil(Float preBuckleOil) {
        this.preBuckleOil = preBuckleOil;
    }

    public Long getPreBuckleTime() {
        return preBuckleTime;
    }

    public void setPreBuckleTime(Long preBuckleTime) {
        this.preBuckleTime = preBuckleTime;
    }
    public String getDisId() {
        return disId;
    }

    public void setDisId(String disId) {
        this.disId = disId;
    }
}
