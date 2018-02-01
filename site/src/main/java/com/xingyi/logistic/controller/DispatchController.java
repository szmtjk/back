package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.AvailableDispatchShip;
import com.xingyi.logistic.business.model.CustomerTaskFlow4DispatchQuery;
import com.xingyi.logistic.business.model.DispatchInfo;
import com.xingyi.logistic.business.model.DispatchInfoParam;
import com.xingyi.logistic.business.model.DispatchInfoQuery;
import com.xingyi.logistic.business.model.GetDispatchShipParam;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.DispatchInfoService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jadic on 2018/1/21.
 */
@RestController
@RequestMapping("/dispatch")
public class DispatchController extends BaseCRUDController<DispatchInfo, DispatchInfoQuery> {

    //根据流向订单获取筛选合适的船舶信息

    //根据任务流向id获取合适的船舶信息

    //确认下单，生成调度计划
    @Autowired
    private DispatchInfoService dispatchInfoService;

    @RequestMapping("/getCustomerTaskFlowList")
    public JsonRet<Object> getCustomerTaskFlowList(@JsonParam CustomerTaskFlow4DispatchQuery query) {
        return dispatchInfoService.getCustomerTaskFlows(query);
    }

    @RequestMapping("/getAvailableShips")
    public JsonRet<Object> getAvailableShips(@JsonParam GetDispatchShipParam param) {
        return dispatchInfoService.getAvailableShips(param);
    }

    @RequestMapping("/confirmPlan")
    public JsonRet<Boolean> confirmDispatchInfoPlan(@JsonParam DispatchInfoParam dispatchInfoParam) {
        return dispatchInfoService.confirmDispatchInfoPlan(dispatchInfoParam);
    }
    @RequestMapping("/confirmPlanTest")
    public JsonRet<Boolean> confirmDispatchInfoPlan2(@RequestBody DispatchInfoParam dispatchInfoParam) {
        return dispatchInfoService.confirmDispatchInfoPlan(dispatchInfoParam);
    }

    @Override
    protected BaseService<DispatchInfo, DispatchInfoQuery> getBaseService() {
        return dispatchInfoService;
    }

}
