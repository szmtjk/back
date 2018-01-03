package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Jadic on 2017/12/31.
 */
public class BasePort extends BaseModelAndDO {

    @NotNullEmpty
    private String portNo;//港口编号
    @NotNullEmpty
    private String name;//名称
    @AllowedNumber(values = {1, 2}, message = "港口类型错误")
    private Integer portType;//港口类型 1：集装箱 2：其他
    @NotNullEmpty
    private String company;//所属公司
    @NotNull
    @Max(value = 180000000, message = "超出经度范围")
    @Min(value = 0)
    private Long longitude;//经度
    @NotNull
    @Max(value = 90000000, message = "超出维度范围")
    @Min(value = 0)
    private Long latitude;//纬度
    @NotNull
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
