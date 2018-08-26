package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

/**
 * Created by xiaohu on 2018/8/25.
 */
public class OperationLogQuery extends BaseQueryPage {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
