package com.xingyi.logistic.business.service;

import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.business.model.Port;
import com.xingyi.logistic.business.model.PortQuery;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.model.AppUser;

/**
 * Created by Jadic on 2017/12/31.
 */
public interface ShipService extends BaseService<Ship, ShipQuery> {
    JsonRet<Object> getAppById(AppUser mAppUser);

    JsonRet<Object> getShipInfo(UserProfile profile);
}
