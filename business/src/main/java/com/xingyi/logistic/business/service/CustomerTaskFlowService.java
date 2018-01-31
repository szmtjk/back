package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.Combox;
import com.xingyi.logistic.business.model.CustomerTaskFlow;
import com.xingyi.logistic.business.model.CustomerTaskFlowQuery;
import com.xingyi.logistic.common.bean.JsonRet;

import java.util.List;
import java.util.Map;

/**
 * 客户任务流向
 */
public interface CustomerTaskFlowService extends BaseService<CustomerTaskFlow, CustomerTaskFlowQuery> {

    public JsonRet<Long> queryTotalWeightInfo(Map<String, String> map);

    /**
     * 从运价管理中取（客户、合同、流向、时间）
     * @param map
     * @return
     */
    public List<Combox> queryUnitPriceInfo(Map<String, String> map);
}
