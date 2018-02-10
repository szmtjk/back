package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

/**
 * 客户任务流向
 */
public class CustomerTaskFlow4DispatchQuery extends BaseQueryPage {

    private String key;
    private Integer flag;//特殊标识 1：包含已调度

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}
