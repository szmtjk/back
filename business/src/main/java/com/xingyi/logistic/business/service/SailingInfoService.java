package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.SailingInfo;
import com.xingyi.logistic.business.model.SailingInfoQuery;

import java.util.List;
import java.util.Map;

/**
 * 航次信息
 */
public interface SailingInfoService extends BaseService<SailingInfo,SailingInfoQuery> {

    /**
     * 加载所有的调度计划
     * @param map
     * @return
     */
    List<Map<String, Object>> queryDispatchShipInfo(Map<String, String> map);

    /**
     * 加载未处理的所有调度计划
     * @param map
     * @return
     */
    List<Map<String, Object>> queryUnDealDispatchShipInfo(Map<String, String> map);
}
