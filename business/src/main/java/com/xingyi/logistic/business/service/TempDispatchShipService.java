package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.TempDispatchShip;
import com.xingyi.logistic.business.model.TempDispatchShipQuery;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.model.AppUser;

/**
 * 临调船舶
 */
public interface TempDispatchShipService extends BaseService<TempDispatchShip, TempDispatchShipQuery> {

    JsonRet<Object> getAppById(AppUser mAppUser);


}
