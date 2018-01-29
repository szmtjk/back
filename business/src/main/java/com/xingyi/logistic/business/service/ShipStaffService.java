package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.*;
import com.xingyi.logistic.common.bean.JsonRet;

/**
 * 船舶人员
 */
public interface ShipStaffService extends BaseService<ShipStaff, ShipStaffQuery> {

    JsonRet<Integer> judege(ShipStaff shipStaff);
}
