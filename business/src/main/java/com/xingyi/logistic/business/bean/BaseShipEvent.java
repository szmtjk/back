package com.xingyi.logistic.business.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

public class BaseShipEvent extends BaseModelAndDO{

    @NotNullEmpty
    private Long shipId;

    @NotNullEmpty
    @AllowedNumber(values = {1, 2, 3, 4, 5, 6, 7, 8, 9}, message = "事件类型错误")
    private Integer eventId;//事件类型：1不接电话,2停船过夜,3不服调配,4修船,5保养,6事故停航,7私事停航,8春节放假,9装卸货异常情况

    private String beginDate;//开始日期
    private String endDate;//结束日期
    private Long dayNum; //总天数
    /**
     * 备注

     */
    private String description;

    /**
     * 是否已删除
     */
    private Integer isDeleted;


    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Long getDayNum() {
        return dayNum;
    }

    public void setDayNum(Long dayNum) {
        this.dayNum = dayNum;
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
