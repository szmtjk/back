package com.szmtjk.authentication.model;

import com.szmtjk.business.bean.base.BaseQueryPage;

public class ActionResourcesQuery extends BaseQueryPage {
    private String key;

    public ActionResourcesQuery(){

    }

    public ActionResourcesQuery(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
