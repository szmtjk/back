package com.xingyi.logistic.business.bean;


import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

/**
 * 危险区域
 */
public class BaseDangerZone extends BaseModelAndDO {

    @NotNullEmpty
    private String name;
    private Long longitude;//经度
    private Long latitude;//维度
    private Long radius;//半径
    private Long alarmDistance; //报警距离
    @AllowedNumber(values = {1, 2})
    private Integer status; //状态  1：启用 2：禁用
    private String description;
    private String msgTemplate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Long getRadius() {
        return radius;
    }

    public void setRadius(Long radius) {
        this.radius = radius;
    }

    public Long getAlarmDistance() {
        return alarmDistance;
    }

    public void setAlarmDistance(Long alarmDistance) {
        this.alarmDistance = alarmDistance;
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
