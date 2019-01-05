package com.szmtjk.business.model;

import com.szmtjk.business.bean.BaseQueryPage;

public class PushAppMsgQuery extends BaseQueryPage {

    private Long id;

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
