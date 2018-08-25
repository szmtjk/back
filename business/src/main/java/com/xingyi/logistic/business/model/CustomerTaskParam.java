package com.xingyi.logistic.business.model;

import com.xingyi.logistic.common.annotation.NotNullEmpty;

/**
 * Created by xiaohu on 2018/8/25.
 */
public class CustomerTaskParam {

    private Long customerTaskId;

    @NotNullEmpty
    private String taskNo;

    public Long getCustomerTaskId() {
        return customerTaskId;
    }

    public void setCustomerTaskId(Long customerTaskId) {
        this.customerTaskId = customerTaskId;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }
}
