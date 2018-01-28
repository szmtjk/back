package com.xingyi.logistic.qiangdan.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

public class ReservationQuery extends BaseQueryPage {

    private Integer leftDispatchId;
    private Integer userId;
    private Integer status;

    public Integer getLeftDispatchId() {
        return leftDispatchId;
    }

    public void setLeftDispatchId(Integer leftDispatchId) {
        this.leftDispatchId = leftDispatchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
