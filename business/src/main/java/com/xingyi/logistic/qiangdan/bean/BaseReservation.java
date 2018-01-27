package com.xingyi.logistic.qiangdan.bean;

import com.xingyi.logistic.business.bean.BaseModelAndDO;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.xml.ws.BindingType;

public class BaseReservation extends BaseModelAndDO {

    /**
     * 用户id
     */
    @NotNullEmpty
    private Integer userId;

    /**
     * 船舶经度
     */
    @NotNullEmpty
    private Integer shipLongitude;

    /**
     * 船舶纬度
     */
    @NotNullEmpty
    private Integer shipLatitude;

    /**
     * 预报吨位
     */
    @NotNullEmpty
    private Integer preLoad;

    /**
     * 预计到达港口时间
     */
    @NotNullEmpty
    private Integer preArrivePortTime;

    /**
     * 空船照片
     */
    @NotNullEmpty
    private String shipEmptyPhoto;

    /**
     * 参照物照片
     */
    @NotNullEmpty
    private String shipReference;

    /**
     * 状态
     */
    @NotNullEmpty
    private Integer status;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShipLongitude() {
        return shipLongitude;
    }

    public void setShipLongitude(Integer shipLongitude) {
        this.shipLongitude = shipLongitude;
    }

    public Integer getShipLatitude() {
        return shipLatitude;
    }

    public void setShipLatitude(Integer shipLatitude) {
        this.shipLatitude = shipLatitude;
    }

    public Integer getPreLoad() {
        return preLoad;
    }

    public void setPreLoad(Integer preLoad) {
        this.preLoad = preLoad;
    }

    public Integer getPreArrivePortTime() {
        return preArrivePortTime;
    }

    public void setPreArrivePortTime(Integer preArrivePortTime) {
        this.preArrivePortTime = preArrivePortTime;
    }

    public String getShipEmptyPhoto() {
        return shipEmptyPhoto;
    }

    public void setShipEmptyPhoto(String shipEmptyPhoto) {
        this.shipEmptyPhoto = shipEmptyPhoto;
    }

    public String getShipReference() {
        return shipReference;
    }

    public void setShipReference(String shipReference) {
        this.shipReference = shipReference;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
