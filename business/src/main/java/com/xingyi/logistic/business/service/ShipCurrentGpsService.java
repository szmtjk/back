package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.*;

import java.util.List;

/**
 * Created by WCL on 2018/1/12.
 */
public interface ShipCurrentGpsService extends BaseService<ShipCurrentGps, ShipCurrentGpsQuery> {

    /**
     * 获取所有定位数据
     * @return
     */
    public List<ShipCurrentGps> getShipCurrentGpsAll();

    /**
     * 加载所有设备
     * @return
     */
    public List<Combox> queryComboxShipInfo();

    /**
     * 加载客户
     * @return
     */
    public List<Combox> queryComboxCustomerInfo();

    /**
     * 加载所有船与设备的关系
     * @return
     */
    public List<ShipDev> getShipDev();

    /**
     * 加载所有港口
     * @return
     */
    public List<Port> getLoadPortAll();

    /**
     * 加载所有危险区域
     * @return
     */
    public List<DangerZone> getLoadDangerZone();

    /**
     * 加载所有航道
     * @return
     */
    public List<DangerZoneSpeed> getLoadDangerZoneSpeed();


    /**
     * 根据相关条件查询实时定位数据
     * @param shipCurrentGpsQuery
     * @return
     */
    public List<ShipCurrentGps> queryShipCurrentGpsInfo(ShipCurrentGpsQuery shipCurrentGpsQuery);
}
