package com.xingyi.logistic.business.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;

/**
 * Created by xiaohu on 2018/10/28.
 */
public class UserThirdPartyDBQuery extends BaseDBQueryPage {

    private Long userId;
    private Integer thirdType;
    private String thirdId;
    private String thirdName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getThirdType() {
        return thirdType;
    }

    public void setThirdType(Integer thirdType) {
        this.thirdType = thirdType;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }
}
