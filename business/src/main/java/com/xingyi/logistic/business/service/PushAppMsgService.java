package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.db.entity.PushAppMsgDO;
import com.xingyi.logistic.business.model.PushAppMsg;
import com.xingyi.logistic.business.model.PushAppMsgQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.model.AppUser;

import java.util.List;
import java.util.Map;

public interface PushAppMsgService extends BaseService<PushAppMsg, PushAppMsgQuery> {

    JsonRet<Object> getAppById(AppUser mAppUser);

    JsonRet<List<PushAppMsgDO>> getListById(PushAppMsgDO pushAppMsgDO);

    PushAppMsgDO getReservationInfo(Map<String,Object> map);
}
