package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

/**
 * 客户任务
 */
public class CustomerTaskQuery extends BaseQueryPage {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String  customerId ;//客户id

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
