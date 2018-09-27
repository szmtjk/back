package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.db.entity.ShipOilDO;
import com.xingyi.logistic.business.model.ShipOil;
import com.xingyi.logistic.business.model.ShipOilQuery;
import com.xingyi.logistic.common.bean.JsonRet;

import java.util.List;

/**
 * Created by wzf on 2017/12/31.
 */
public interface ShipOilService extends BaseService<ShipOil, ShipOilQuery> {

    JsonRet<Object> calculateRemainingOil(ShipOilQuery query);
}
