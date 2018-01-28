package com.xingyi.logistic.business.bean;

/**
 * Created by Jadic on 2018/1/28.
 */
public class BaseLeftDispatch4Check {

    private Integer id;
    private String goodsName;
    private Integer goodsType;
    private Integer loadingTime;
    private String startPortName;
    private String endPortName;
    private Integer dispatchWeight;
    private Integer preLoadChecked;
    private Integer shipCountChecked;
    private Integer preLoadUnchecked;
    private Integer shipCountUnchecked;
    private Integer taskStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(Integer loadingTime) {
        this.loadingTime = loadingTime;
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

    public Integer getDispatchWeight() {
        return dispatchWeight;
    }

    public void setDispatchWeight(Integer dispatchWeight) {
        this.dispatchWeight = dispatchWeight;
    }

    public Integer getPreLoadChecked() {
        return preLoadChecked;
    }

    public void setPreLoadChecked(Integer preLoadChecked) {
        this.preLoadChecked = preLoadChecked;
    }

    public Integer getPreLoadUnchecked() {
        return preLoadUnchecked;
    }

    public void setPreLoadUnchecked(Integer preLoadUnchecked) {
        this.preLoadUnchecked = preLoadUnchecked;
    }

    public Integer getShipCountUnchecked() {
        return shipCountUnchecked;
    }

    public void setShipCountUnchecked(Integer shipCountUnchecked) {
        this.shipCountUnchecked = shipCountUnchecked;
    }

    public Integer getShipCountChecked() {
        return shipCountChecked;
    }

    public void setShipCountChecked(Integer shipCountChecked) {
        this.shipCountChecked = shipCountChecked;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }
}
