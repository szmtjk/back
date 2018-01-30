package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.CustomerTaskFlow;
import com.xingyi.logistic.business.model.CustomerTaskFlowQuery;
import com.xingyi.logistic.common.bean.JsonRet;

import java.util.Map;

/**
 * 客户任务流向
 */
public interface CustomerTaskFlowService extends BaseService<CustomerTaskFlow, CustomerTaskFlowQuery> {

    public JsonRet<Long> queryTotalWeightInfo(Map<String, String> map);
}
