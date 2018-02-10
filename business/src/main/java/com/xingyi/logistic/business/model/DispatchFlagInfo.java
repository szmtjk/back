package com.xingyi.logistic.business.model;

/**
 * Created by Jadic on 2018/1/21.
 */
public class DispatchFlagInfo extends DispatchInfo {

    private Integer flag;
    private Integer stashStatus;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getStashStatus() {
        return stashStatus;
    }

    public void setStashStatus(Integer stashStatus) {
        this.stashStatus = stashStatus;
    }
}
