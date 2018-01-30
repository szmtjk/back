package com.xingyi.logistic.business.bean;


import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

/**
 * 危险区域速度
 */
public class BaseDangerZoneSpeed extends BaseModelAndDO {

    @NotNullEmpty
    private String name;
    private String coordinate;//经纬度集合
    private Float minSpeed;//最小速度
    private Float maxSpeed;//最大速度
    @AllowedNumber(values = {1, 2})
    private Integer status; //状态  1：启用 2：禁用
    private String description;
    private String msgTemplate;

    public Float getMinSpeed() {
        return minSpeed;
    }

    public void setMinSpeed(Float minSpeed) {
        this.minSpeed = minSpeed;
    }

    public Float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
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

    public String getMsgTemplate() {
        return msgTemplate;
    }

    public void setMsgTemplate(String msgTemplate) {
        this.msgTemplate = msgTemplate;
    }
}
