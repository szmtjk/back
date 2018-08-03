package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BasePushAppMsg;

public class PushAppMsg extends BasePushAppMsg{

    @Override
    public Long getUserId() {
        return super.getUserId();
    }

    @Override
    public String getNotificationTitle() {
        return super.getNotificationTitle();
    }

    @Override
    public String getMsgTitle() {
        return super.getMsgTitle();
    }

    @Override
    public String getMsgContent() {
        return super.getMsgContent();
    }

    @Override
    public String getExtrasParam() {
        return super.getExtrasParam();
    }

    @Override
    public void setUserId(Long userId) {
        super.setUserId(userId);
    }

    @Override
    public void setNotificationTitle(String notificationTitle) {
        super.setNotificationTitle(notificationTitle);
    }

    @Override
    public void setMsgTitle(String msgTitle) {
        super.setMsgTitle(msgTitle);
    }

    @Override
    public void setMsgContent(String msgContent) {
        super.setMsgContent(msgContent);
    }

    @Override
    public void setExtrasParam(String extrasParam) {
        super.setExtrasParam(extrasParam);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
