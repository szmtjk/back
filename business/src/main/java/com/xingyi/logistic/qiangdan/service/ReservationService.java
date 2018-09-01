package com.xingyi.logistic.qiangdan.service;

import com.xingyi.logistic.business.model.ReservationCheckParam;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.model.AppUser;
import com.xingyi.logistic.qiangdan.model.Reservation;
import com.xingyi.logistic.qiangdan.model.ReservationQuery;

import java.util.Map;

public interface ReservationService extends BaseService<Reservation,ReservationQuery> {

    JsonRet<Object> queryMyOrderInfo(Map<String, Object> map);

    JsonRet<Object> getAppById(Map<String, Object> map);

    JsonRet<Boolean> check(ReservationCheckParam reservationCheckParam);

}
