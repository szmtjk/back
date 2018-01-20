package com.xingyi.logistic.business.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

public class BaseTerminalMsg extends BaseModelAndDO{
    /**
     * 船舶id
     */
    @NotNullEmpty
    private Integer shipId;

    /**
     * 设备id
     */
    @NotNullEmpty
    private String deviceId;

    /**
     * 消息标题
     */
    @NotNullEmpty
    private String title;

    /**
     * 消息内容
     */
    @NotNullEmpty
    private String content;

    /**
     * 消息状态 1:已下发 2：发送成功  3：发送失败
     */
    private Integer status;

    /**
     *  是否删除
     */
    private Integer isDeleted;

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}
