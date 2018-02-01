package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.AvailableDispatchShip;
import com.xingyi.logistic.business.model.CustomerTaskFlow4DispatchQuery;
import com.xingyi.logistic.business.model.DispatchInfo;
import com.xingyi.logistic.business.model.DispatchInfoParam;
import com.xingyi.logistic.business.model.DispatchInfoQuery;
import com.xingyi.logistic.business.model.GetDispatchShipParam;
import com.xingyi.logistic.common.bean.JsonRet;

import java.util.List;

/**
 * Created by Jadic on 2018/1/21.
 */
public interface DispatchInfoService extends BaseService<DispatchInfo, DispatchInfoQuery> {

    JsonRet<Boolean> confirmDispatchInfoPlan(DispatchInfoParam dispatchInfoParam);

    JsonRet<Object> getAvailableShips(GetDispatchShipParam param);

    JsonRet<Object> getCustomerTaskFlows(CustomerTaskFlow4DispatchQuery query);
}
