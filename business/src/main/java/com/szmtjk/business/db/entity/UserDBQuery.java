package com.szmtjk.business.db.entity;

import com.szmtjk.business.bean.base.BaseDBQueryPage;

/**
 * auto generated by code helper on 2019-01-05.
 */
public class UserDBQuery extends BaseDBQueryPage {

    private String userName;
    private String mobile;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
