package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.*;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShipCurrentGpsService;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    @Override
    protected BaseService<ShipCurrentGps, ShipCurrentGpsQuery> getBaseService()
    {
        return shipCurrentGpsService;
    }

}
