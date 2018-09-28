package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.SailingInfo;
import com.xingyi.logistic.business.model.SailingInfoQuery;
import com.xingyi.logistic.common.bean.JsonRet;

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

    /**
     * 加载已调度的船舶任务
     * @param map
     * @return
     */
    JsonRet<Object> getDispatchShipTaskList(SailingInfoQuery query);

    /**
     * 加载已调度的船舶任务
     * @param map
     * @return
     */
    JsonRet<Object> getSailingShipTaskList(SailingInfoQuery query);

    JsonRet<Boolean> modifyBalance(Long id);
}
