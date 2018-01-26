package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ShipCurrentGpsDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipCurrentGpsDBQuery;
import com.xingyi.logistic.business.db.entity.ShipCurrentGpsDO;
import com.xingyi.logistic.business.model.*;
import com.xingyi.logistic.business.service.ShipCurrentGpsService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShipCurrentGpsConverter;
import com.xingyi.logistic.business.service.converter.ShipCurrentGpsQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by WCL on 2018/1/12.
 */
@Service
public class ShipCurrentGpsServiceImpl extends BaseCRUDService<ShipCurrentGpsDO, ShipCurrentGps, ShipCurrentGpsDBQuery, ShipCurrentGpsQuery> implements ShipCurrentGpsService {
    @Autowired
    private ShipCurrentGpsDAO shipCurrentGpsDAO;

    @Autowired
    private ShipCurrentGpsConverter shipCurrentGpsConverter;

    @Autowired
    private ShipCurrentGpsQueryConverter shipCurrentGpsQueryConverter;

    @Override
    protected ModelConverter<ShipCurrentGpsDO, ShipCurrentGps> getModelConverter() {
        return shipCurrentGpsConverter;
    }

    @Override
    protected BaseDAO<ShipCurrentGpsDO, ShipCurrentGpsDBQuery> getDAO() {
        return shipCurrentGpsDAO;
    }

    @Override
    protected QueryConditionConverter<ShipCurrentGpsQuery, ShipCurrentGpsDBQuery> getConditionConverter() {
        return shipCurrentGpsQueryConverter;
    }

    public List<ShipCurrentGps> getShipCurrentGpsAll()
    {
        List<ShipCurrentGpsDO> doList = shipCurrentGpsDAO.getShipCurrentGpsAll();
        return doList.stream().map(getModelConverter()::toModel).collect(Collectors.toList());
    }

    /**
     * 加载所有设备
     * @return
     */
    public List<Combox> queryComboxShipInfo()
    {
        return shipCurrentGpsDAO.queryComboxShipInfo();
    }


    /**
     * 加载客户
     * @return
     */
    public List<Combox> queryComboxCustomerInfo()
    {
        return shipCurrentGpsDAO.queryComboxCustomerInfo();
    }


    public List<ShipDev> getShipDev()
    {
        return shipCurrentGpsDAO.getShipDev();
    }

    /**
     * 加载所有港口
     * @return
     */
    public List<Port> getLoadPortAll()
    {
        return shipCurrentGpsDAO.getLoadPortAll();
    }

    /**
     * 加载所有危险区域
     * @return
     */
    public List<DangerZone> getLoadDangerZone()
    {
        return shipCurrentGpsDAO.getLoadDangerZone();
    }

    /**
     * 加载所有航道
     * @return
     */
    public List<DangerZoneSpeed> getLoadDangerZoneSpeed()
    {
        return shipCurrentGpsDAO.getLoadDangerZoneSpeed();
    }

    /**
     * 加载行次任务表数据
     * @return
     */
    public List<SailingData> querySailingInfo()
    {
        return shipCurrentGpsDAO.querySailingInfo();
    }



    /**
     * 加载调度计划
     * @return
     */
    public List<DispatchData> queryDispatchInfo()
    {
        return shipCurrentGpsDAO.queryDispatchInfo();
    }


    /**
     * 根据相关条件查询实时定位数据
     * @param shipCurrentGpsQuery
     * @return
     */
    public List<ShipCurrentGps> queryShipCurrentGpsInfo(ShipCurrentGpsQuery shipCurrentGpsQuery)
    {
        //ShipCurrentGpsDBQuery shipCurrentGpsDBQuery = getConditionConverter().toDOCondition(shipCurrentGpsQuery);
        List<ShipCurrentGpsDO> doList = shipCurrentGpsDAO.queryShipCurrentGpsInfo(shipCurrentGpsQuery);
        return doList.stream().map(getModelConverter()::toModel).collect(Collectors.toList());
    }
}
