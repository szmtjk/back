package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

/**
 * 航次
 */
public class SailingInfoQuery extends BaseQueryPage {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private  String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
