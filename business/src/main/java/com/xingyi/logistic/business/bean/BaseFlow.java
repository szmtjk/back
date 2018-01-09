package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.validation.constraints.NotNull;

/**
 * 流向信息
 */
public class BaseFlow extends BaseModelAndDO {

    @NotNullEmpty
   private String name;
   private Long startFlow;//起始流向
    private Long endFlow;//
    private Long startPortId;//
    private Long endPortId;//
    private Integer sailingArea;//
    private Integer waterLevelPoint;//
    @AllowedNumber(values = {1, 2})
    private Integer status; //状态  1：启用 2：禁用
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStartFlow() {
        return startFlow;
    }

    public void setStartFlow(Long startFlow) {
        this.startFlow = startFlow;
    }

    public Long getEndFlow() {
        return endFlow;
    }

    public void setEndFlow(Long endFlow) {
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

    public Integer getWaterLevelPoint() {
        return waterLevelPoint;
    }

    public void setWaterLevelPoint(Integer waterLevelPoint) {
        this.waterLevelPoint = waterLevelPoint;
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
