package com.xingyi.logistic.business.bean;

/**
 * Created by Jadic on 2017/12/31.
 */
public class BasePort extends BaseModelAndDO {

    private String portNo;//港口编号
    private String name;//名称
    private Integer portType;//港口类型 1：集装箱 2：其他
    private String company;//所属公司
    private Long longitude;//经度
    private Long latitude;//纬度
    private Long radius;//港口半径
    private String description;//备注

    public String getPortNo() {
        return portNo;
    }

    public void setPortNo(String portNo) {
        this.portNo = portNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPortType() {
        return portType;
    }

    public void setPortType(Integer portType) {
        this.portType = portType;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
