package com.xxx.common.bean;

/**
 * Created by Jadic on 2018/1/8.
 */
public enum QueryType {

    DEFAULT(0),
    MINIUI(1),
    ;
    private int code;

    QueryType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
