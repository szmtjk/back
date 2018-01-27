package com.xingyi.logistic.business.model;

import com.xingyi.logistic.business.bean.BaseQueryPage;

import java.util.List;

/**
 * Created by Jadic on 2017/12/31.
 */
public class ShipQuery extends BaseQueryPage {
    private String key;
    private List<Integer> shipTypeList;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Integer> getShipTypeList() {
        return shipTypeList;
    }

    public void setShipTypeList(List<Integer> shipTypeList) {
        this.shipTypeList = shipTypeList;
    }
}
