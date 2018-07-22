package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.*;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.DispatchInfoService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/getCustomerTaskFlowList", method = RequestMethod.POST)
    public JsonRet<Object> getCustomerTaskFlowList(@JsonParam CustomerTaskFlow4DispatchQuery query) {
        return dispatchInfoService.getCustomerTaskFlows(query);
    }
    /**
     * 调度单号加载
     */
    @RequestMapping(value = "/loadDispatchInfo", method = RequestMethod.POST)
    public List<Map<String,Object>> loadDispatchInfo(@JsonParam ReportParam param) {
        return dispatchInfoService.getDispatchInfoInfo(param);
    }

    @RequestMapping(value = "/getAvailableShips", method = RequestMethod.POST)
    public JsonRet<Object> getAvailableShips(@JsonParam GetDispatchShipParam param) {
        return dispatchInfoService.getAvailableShips(param);
    }

    @RequestMapping(value = "/confirmPlan", method = RequestMethod.POST)
    public JsonRet<Boolean> confirmDispatchInfoPlan(@JsonParam DispatchInfoParam dispatchInfoParam) {
        return dispatchInfoService.confirmDispatchInfoPlan(dispatchInfoParam);
    }

    @Override
    protected BaseService<DispatchInfo, DispatchInfoQuery> getBaseService() {
        return dispatchInfoService;
    }


    @RequestMapping("/getPoundBalanceList")
    public JsonRet<Object> getPoundBalanceList(@JsonParam ReportParam param) {
        return dispatchInfoService.getPoundBalanceList(param);
    }

    @RequestMapping("/getReportFiveList")
    public JsonRet<Object> getReportFiveList(@JsonParam ReportParam param) {
        return dispatchInfoService.getReportFiveList(param);
    }

    @RequestMapping("/getReportThreeList")
    public List<Map<String,Object>> getReportThreeList(@JsonParam ReportParam param) {
        return dispatchInfoService.getReportThreeList(param);
    }

    @RequestMapping("/getReportFour2ThreeList")
    public List<Map<String,Object>> getReportFour2ThreeList(@JsonParam ReportParam param) {
        return dispatchInfoService.getReportFour2ThreeList(param);
    }

    @RequestMapping("/getReportFour2TwoList")
    public List<Map<String,Object>> getReportFour2TwoList(@JsonParam ReportParam param) {
        return dispatchInfoService.getReportFour2TwoList(param);
    }

    @RequestMapping("/getReportFour2OneList")
    public List<Map<String,Object>> getReportFour2OneList(@JsonParam ReportParam param) {
        return dispatchInfoService.getReportFour2OneList(param);
    }

    @RequestMapping("/getReportFour2FourList")
    public List<Map<String,Object>> getReportFour2FourList(@JsonParam ReportParam param) {
        return dispatchInfoService.getReportFour2FourList(param);
    }

    @RequestMapping("/getReportTwoHeader")
    public List<Map<String,Object>> getReportTwoHeader(@JsonParam ReportParam param) {
        return dispatchInfoService.getReportTwoHeader(param);
    }

    @RequestMapping("/getReportTwoList")
    public List<Map<String,Object>> getReportTwoList(@JsonParam ReportParam param) {
        return dispatchInfoService.getReportTwoList(param);
    }

    @RequestMapping("/getFlowByContractId")
    public List<Map<String,Object>> getFlowByContractId(@JsonParam ReportParam param) {
        return dispatchInfoService.getFlowByContractId(param);
    }

    @RequestMapping("/getReportSixList")
    public JsonRet<Object> getReportSixList(@JsonParam ReportParam param) {
        return dispatchInfoService.getReportSixList(param);
    }
}
