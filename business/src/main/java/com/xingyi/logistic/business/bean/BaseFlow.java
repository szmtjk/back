package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

/**
 * 流向信息
 */
public class BaseFlow extends BaseModelAndDO {

    @NotNullEmpty
   private String name;
   private String startFlow;//起始流向
    private String endFlow;//
    private Long startPortId;//起始港口
    private Long endPortId;//
    private Integer sailingArea;//航行区域 按位存储信息
    private String waterLevelPoint;//水位点

    private String sailingTime;//水位点
    @AllowedNumber(values = {1, 2})
    private Integer status; //状态  1：启用 2：禁用
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartFlow() {
        return startFlow;
    }

    public void setStartFlow(String startFlow) {
        this.startFlow = startFlow;
    }

    public String getEndFlow() {
        return endFlow;
    }

    public void setEndFlow(String endFlow) {
        this.endFlow = endFlow;
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

    public Integer getSailingArea() {
        return sailingArea;
    }

    public void setSailingArea(Integer sailingArea) {
        this.sailingArea = sailingArea;
    }

    public String getWaterLevelPoint() {
        return waterLevelPoint;
    }

    public void setWaterLevelPoint(String waterLevelPoint) {
        this.waterLevelPoint = waterLevelPoint;
    }

    public String getSailingTime() {
        return sailingTime;
    }

    public void setSailingTime(String sailingTime) {
        this.sailingTime = sailingTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
