package com.szmtjk.business.bean.wechat;

/**
 * Created by xiaohu on 2018/10/26.
 */
public class ValueColorPair {

    private String value;
    private String color;

    public ValueColorPair(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
