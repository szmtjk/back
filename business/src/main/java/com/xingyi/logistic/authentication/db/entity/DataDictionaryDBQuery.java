package com.xingyi.logistic.authentication.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;

public class DataDictionaryDBQuery extends BaseDBQueryPage {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
