package com.xingyi.logistic.business.model;

/**
 * Created by Jadic on 2018/1/22.
 */
public class AvailableDispatchShip {

    private Long shipId;
    private String shipNo;
    private Integer preWeight;
    private Integer preArriveTime;
    private String arrivalPort;
    private Integer shipStatus;
    private Integer shipType;
    private Integer shipFlag;
    private String captain;
    private String combineMobile;
    private String sailArea;
    private String description;

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public Integer getPreWeight() {
        return preWeight;
    }

    public void setPreWeight(Integer preWeight) {
        this.preWeight = preWeight;
    }

    public Integer getPreArriveTime() {
        return preArriveTime;
    }

    public void setPreArriveTime(Integer preArriveTime) {
        this.preArriveTime = preArriveTime;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public Integer getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(Integer shipStatus) {
        this.shipStatus = shipStatus;
    }

    public Integer getShipType() {
        return shipType;
    }

    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getCombineMobile() {
        return combineMobile;
    }

    public void setCombineMobile(String combineMobile) {
        this.combineMobile = combineMobile;
    }

    public String getSailArea() {
        return sailArea;
    }

    public void setSailArea(String sailArea) {
        this.sailArea = sailArea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getShipFlag() {
        return shipFlag;
    }

    public void setShipFlag(Integer shipFlag) {
        this.shipFlag = shipFlag;
    }
}
