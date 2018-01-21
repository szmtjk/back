package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

/**
 * 消息模板
 */
public class MsgTemplateQuery extends BaseQueryPage {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
