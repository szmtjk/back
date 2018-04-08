package com.xingyi.logistic.business.bean;


/**
 * 船舶加油管理
 */
public class BaseStaffSign extends BaseModelAndDO {

    private Integer staffId;//staffId员工id
    private Integer longitude;//longitude经度
    private Integer latitude;//latitude纬度
    private String gpsAddress;//gpsAddress位置地址

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public String getGpsAddress() {
        return gpsAddress;
    }

    public void setGpsAddress(String gpsAddress) {
        this.gpsAddress = gpsAddress;
    }
}
