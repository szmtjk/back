package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.LeftDispatch4CheckQuery;
import com.xingyi.logistic.business.model.LeftDispatchInfo;
import com.xingyi.logistic.business.model.LeftDispatchInfoQuery;
import com.xingyi.logistic.common.bean.JsonRet;

/**
 * 余量临调信息
 */
public interface LeftDispatchInfoService extends BaseService<LeftDispatchInfo,LeftDispatchInfoQuery>{

    JsonRet<Object> getLeftDispatch4Check(LeftDispatch4CheckQuery query);

}
