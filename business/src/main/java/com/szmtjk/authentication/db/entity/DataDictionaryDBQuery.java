package com.szmtjk.authentication.db.entity;

import com.szmtjk.business.bean.BaseDBQueryPage;

public class DataDictionaryDBQuery extends BaseDBQueryPage {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
