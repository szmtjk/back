package com.szmtjk.business.bean.wechat;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * Created by xiaohu on 2018/10/26.
 */
public class TemplateMsgData {

    @JSONField(name = "touser")
    private String toUser;
    @JSONField(name = "template_id")
    private String templateId;
    private Map<String, ValueColorPair> data;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public Map<String, ValueColorPair> getData() {
        return data;
    }

    public void setData(Map<String, ValueColorPair> data) {
        this.data = data;
    }
}
