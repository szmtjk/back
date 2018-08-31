package com.xingyi.logistic.business.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class BasePushAppMsg extends BaseModelAndDO{

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 通知标题
     */
    private String notificationTitle;

    /**
     * 消息标题
     */
    private String msgTitle;

    /**
     * 消息内容
     */
    private String msgContent;

    /**
     * 外部参数
     */
    private String extrasParam;

    private Integer isDeleted;

    private String shipNo;

    private String nickName;

    public String getShipNo() {
        return shipNo;
    }

    public String getNickName() {
        return nickName;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public String getExtrasParam() {
        return extrasParam;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public void setExtrasParam(String extrasParam) {
        this.extrasParam = extrasParam;
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
