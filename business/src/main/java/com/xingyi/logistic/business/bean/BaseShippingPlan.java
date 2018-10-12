package com.xingyi.logistic.business.bean;


public class BaseShippingPlan extends BaseModelAndDO {


    private Integer shipClass;//船级

    private String time;//年月份
    private String plan; //计划
    /**
     * 备注

     */
    private String description;

    /**
     * 是否已删除
     */
    private Integer isDeleted;

    public Integer getShipClass() {
        return shipClass;
    }

    public void setShipClass(Integer shipClass) {
        this.shipClass = shipClass;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
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
