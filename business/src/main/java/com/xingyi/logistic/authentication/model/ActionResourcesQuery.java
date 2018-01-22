package com.xingyi.logistic.authentication.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

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
