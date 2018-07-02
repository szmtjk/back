package com.xingyi.logistic.business.service;


import com.xingyi.logistic.business.model.*;
import com.xingyi.logistic.common.bean.JsonRet;

import java.util.List;
import java.util.Map;


/**
 * Created by Jadic on 2018/1/21.
 */
public interface DispatchInfoService extends BaseService<DispatchInfo, DispatchInfoQuery> {

    JsonRet<Boolean> confirmDispatchInfoPlan(DispatchInfoParam dispatchInfoParam);

    JsonRet<Object> getAvailableShips(GetDispatchShipParam param);

    JsonRet<Object> getCustomerTaskFlows(CustomerTaskFlow4DispatchQuery query);

    JsonRet<Object> getPoundBalanceList(ReportParam param);

    JsonRet<Object> getReportFiveList(ReportParam param);

    List<Map<String,Object>> getDispatchInfoInfo(ReportParam param);

    List<Map<String,Object>> getReportThreeList(ReportParam param);

    List<Map<String,Object>> getReportFour2ThreeList(ReportParam param);

    List<Map<String,Object>> getReportFour2TwoList(ReportParam param);

    List<Map<String,Object>> getReportFour2OneList(ReportParam param);

    List<Map<String,Object>> getReportFour2FourList(ReportParam param);

    List<Map<String,Object>> getReportTwoHeader(ReportParam param);

    List<Map<String,Object>> getReportTwoList(ReportParam param);

    List<Map<String,Object>> getFlowByContractId(ReportParam param);

}
