package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.*;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShipCurrentGpsService;
import com.xingyi.logistic.config.JsonParam;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 实时监控与轨迹回放相关的数据
 * Created by WCL on 2018/1/16.
 */
@RestController
@RequestMapping("/gps")
public class GpsRealController extends BaseCRUDController<ShipCurrentGps, ShipCurrentGpsQuery>
{

    @Autowired
    private ShipCurrentGpsService shipCurrentGpsService;


    /**
     * 加载客户
     * @return
     */
    @RequestMapping("/loadCustomer")
    public List<Combox> loadCustomer()
    {
        return shipCurrentGpsService.queryComboxCustomerInfo();
    }

    /**
     * 加载设备
     */
    @RequestMapping("/loadShip")
    public List<Combox> loadShip()
    {
        return shipCurrentGpsService.queryComboxShipInfo();
    }

    /**
     * 加载所有港口数据
     * @return
     */
    @RequestMapping("/loadPortAll")
    public List<Port> loadPortAll()
    {
        return shipCurrentGpsService.getLoadPortAll();
    }

    /**
     * 加载所有危险区域
     * @return
     */
    @RequestMapping("/loadDangerZoneAll")
    public List<DangerZone> loadDangerZoneAll()
    {
        return shipCurrentGpsService.getLoadDangerZone();
    }


    /**
     * 加载所有航道
     * @return
     */
    @RequestMapping("/loadDangerZoneSpeedAll")
    public List<DangerZoneSpeed> loadDangerZoneSpeedAll()
    {
        return shipCurrentGpsService.getLoadDangerZoneSpeed();
    }


    /**
     * 加载所有实时数据
     * @param shipCurrentGpsQuery
     * @return
     */
    @RequestMapping("/loadGpsReal")
    public List<ShipCurrentGps> loadPortAll(@JsonParam ShipCurrentGpsQuery shipCurrentGpsQuery)
    {
        return shipCurrentGpsService.queryShipCurrentGpsInfo(shipCurrentGpsQuery);
    }


    /**
     * 加载行次任务表数据
     * @return
     */
    @RequestMapping("/loadSailing")
    public List<SailingData> loadSailing(HttpServletRequest request)
    {
        System.out.println("===================");
        System.out.println(request.getHeader("token"));
        System.out.println("===================");
        return shipCurrentGpsService.querySailingInfo();
    }

    /**
     * 加载订单计划
     * @return
     */
    @RequestMapping("/loadDispatch")
    public List<DispatchData> loadDispatch()
    {
        return shipCurrentGpsService.queryDispatchInfo();
    }

    /**
     * 加载订单计划
     * @return
     */
    @RequestMapping("/loadDataDict")
    public List<Combox> loadDataDict(@RequestParam Map<String, String> map)
    {
        return shipCurrentGpsService.queryDataDictInfo(map);
    }

    /**
     * 最后一次流量运价
     * @return
     */
    @RequestMapping("/loadContractFlowLastInfo")
    public List<Combox> loadContractFlowLastInfo(@RequestParam Map<String, String> map)
    {
        return shipCurrentGpsService.queryContractFlowLastInfo(map);
    }


    /**
     * 加载用户
     * @return
     */
    @RequestMapping("/loadUserProfile")
    public List<Combox> loadUserProfile()
    {
        return shipCurrentGpsService.queryUserProfileInfo();
    }

    @Override
    protected BaseService<ShipCurrentGps, ShipCurrentGpsQuery> getBaseService()
    {
        return shipCurrentGpsService;
    }



}
