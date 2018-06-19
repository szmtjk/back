package com.xingyi.logistic.business.bean;

/**
 * wzf
 */
public class BasePlanRefueling extends BaseModelAndDO {

    private String disId;//调度单号
    private String shipId;//船号
    private String planRefueling;//计划加油
    private String description;//bz

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisId() {
        return disId;
    }

    public void setDisId(String disId) {
        this.disId = disId;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getPlanRefueling() {
        return planRefueling;
    }

    public void setPlanRefueling(String planRefueling) {
        this.planRefueling = planRefueling;
    }
}
