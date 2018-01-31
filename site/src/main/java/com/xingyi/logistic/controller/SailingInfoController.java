package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.SailingInfo;
import com.xingyi.logistic.business.model.SailingInfoQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.SailingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 航次信息
 */
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
    @RequestMapping("/loadDsipatchShip")
    public List<Map<String, Object >> queryDispatchShipInfo(@RequestParam Map<String, String> map)
    {
        return sailingInfoService.queryDispatchShipInfo(map);
    }

    /**
     * 加载未处理的所有调度计划
     * @param map
     * @return
     */
    @RequestMapping("/loadUnDealDsipatchShip")
    public List<Map<String, Object >> queryUnDealDispatchShipInfo(@RequestParam Map<String, String> map)
    {
        return sailingInfoService.queryUnDealDispatchShipInfo(map);
    }


    @Override
    protected BaseService<SailingInfo,SailingInfoQuery> getBaseService() {
        return sailingInfoService;
    }
}
