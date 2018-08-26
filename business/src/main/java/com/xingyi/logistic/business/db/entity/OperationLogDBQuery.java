package com.xingyi.logistic.business.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;

/**
 * Created by xiaohu on 2018/8/25.
 */
public class OperationLogDBQuery extends BaseDBQueryPage {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
