package com.xingyi.logistic.business.db.entity;

import com.xingyi.logistic.business.bean.BaseDBQueryPage;

import java.util.List;

/**
 * Created by Jadic on 2017/12/31.
 */
public class ShipDBQuery extends BaseDBQueryPage {
    private String key;
    private List<Integer> shipTypes;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Integer> getShipTypes() {
        return shipTypes;
    }

    public void setShipTypes(List<Integer> shipTypes) {
        this.shipTypes = shipTypes;
    }
}
