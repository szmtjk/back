package com.xingyi.logistic.business.bean;

/**
 * Created by Jadic on 2018/1/26.
 */
public class BaseCustomerTaskFlow4Dispatch {

    private Long id;
    private String flowName;
    private String goodsName;
    private Integer loadingTime;
    private String startPortName;
    private String endPortName;
    private Integer totalLoad;
    private Integer leftWeight;
    private Integer goodsType;
    private String sailingArea;
    private String customerName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public Integer getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(Integer totalLoad) {
        this.totalLoad = totalLoad;
    }

    public Integer getLeftWeight() {
        return leftWeight;
    }

    public void setLeftWeight(Integer leftWeight) {
        this.leftWeight = leftWeight;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getSailingArea() {
        return sailingArea;
    }

    public void setSailingArea(String sailingArea) {
        this.sailingArea = sailingArea;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
