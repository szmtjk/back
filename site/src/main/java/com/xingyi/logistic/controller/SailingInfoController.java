package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.aop.annotation.Operation;
import com.xingyi.logistic.business.model.SailingInfo;
import com.xingyi.logistic.business.model.SailingInfoQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.SailingInfoService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 航次信息
 */
@Biz("航次信息")
@RestController
@RequestMapping("/sailingInfo")
public class SailingInfoController extends BaseCRUDController<SailingInfo, SailingInfoQuery> {

    @Autowired
    private SailingInfoService sailingInfoService;

    /**
     * 加载所有的调度计划
     * @param map
     * @return
     */
    @RequestMapping(value = "/loadDispatchShip", method = RequestMethod.POST)
    public List<Map<String, Object >> queryDispatchShipInfo(@RequestParam Map<String, String> map)
    {
        return sailingInfoService.queryDispatchShipInfo(map);
    }

    /**
     * 加载未处理的所有调度计划
     * @param map
     * @return
     */
    @RequestMapping(value = "/loadUnDealDsipatchShip", method = RequestMethod.POST)
    public List<Map<String, Object >> queryUnDealDispatchShipInfo(@RequestParam Map<String, String> map)
    {
        return sailingInfoService.queryUnDealDispatchShipInfo(map);
    }

    /**
     * 加载所有已调度的船舶任务
     * @param map
     * @return
     */
    @RequestMapping(value = "/getDispatchShipTaskList", method = RequestMethod.POST)
    public JsonRet<Object> getDispatchShipTaskList(@JsonParam SailingInfoQuery query)
    {
        return sailingInfoService.getDispatchShipTaskList(query);
    }

    @Operation("船舶运费结算")
    @RequestMapping(value = "/modifyBalance", method = {RequestMethod.POST,RequestMethod.GET})
    public JsonRet<Boolean> modifyBalance(@RequestParam Long id) {
        return sailingInfoService.modifyBalance(id);
    }

    @Override
    protected BaseService<SailingInfo,SailingInfoQuery> getBaseService() {
        return sailingInfoService;
    }
}
