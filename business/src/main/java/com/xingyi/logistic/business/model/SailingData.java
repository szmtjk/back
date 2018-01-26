package com.xingyi.logistic.business.model;

/**
 * Created by WCL on 2018/1/24.
 */
public class SailingData {
    private Long id;
    private Long shipId;
    private Integer status;
    private Long arriveSPortTime;
    private Long loadTime;
    private Long loadWeight;
    private Long preArriveEPortTime;
    private Long departPortTime;
    private Long actualArriveEPortTime;
    private Long dischargeTime;
    private Long dischargeWeight;
    private Float dischargeDelayFee;
    private Long startPortId;
    private Long endPortId;
    private String goodsName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Long getArriveSPortTime() {
        return arriveSPortTime;
    }

    public void setArriveSPortTime(Long arriveSPortTime) {
        this.arriveSPortTime = arriveSPortTime;
    }

    public Long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Long loadTime) {
        this.loadTime = loadTime;
    }

    public Long getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(Long loadWeight) {
        this.loadWeight = loadWeight;
    }

    public Long getPreArriveEPortTime() {
        return preArriveEPortTime;
    }

    public void setPreArriveEPortTime(Long preArriveEPortTime) {
        this.preArriveEPortTime = preArriveEPortTime;
    }

    public Long getDepartPortTime() {
        return departPortTime;
    }

    public void setDepartPortTime(Long departPortTime) {
        this.departPortTime = departPortTime;
    }

    public Long getActualArriveEPortTime() {
        return actualArriveEPortTime;
    }

    public void setActualArriveEPortTime(Long actualArriveEPortTime) {
        this.actualArriveEPortTime = actualArriveEPortTime;
    }

    public Long getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(Long dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    public Long getDischargeWeight() {
        return dischargeWeight;
    }

    public void setDischargeWeight(Long dischargeWeight) {
        this.dischargeWeight = dischargeWeight;
    }

    public Float getDischargeDelayFee() {
        return dischargeDelayFee;
    }

    public void setDischargeDelayFee(Float dischargeDelayFee) {
        this.dischargeDelayFee = dischargeDelayFee;
    }

    public Long getStartPortId() {
        return startPortId;
    }

    public void setStartPortId(Long startPortId) {
        this.startPortId = startPortId;
    }

    public Long getEndPortId() {
        return endPortId;
    }

    public void setEndPortId(Long endPortId) {
        this.endPortId = endPortId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
