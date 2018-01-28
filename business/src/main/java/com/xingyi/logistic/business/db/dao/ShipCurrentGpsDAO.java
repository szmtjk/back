package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipCurrentGpsDBQuery;
import com.xingyi.logistic.business.db.entity.ShipCurrentGpsDO;
import com.xingyi.logistic.business.model.*;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by WCL on 2018/1/12.
 */
@Dao
public interface ShipCurrentGpsDAO extends BaseDAO<ShipCurrentGpsDO, ShipCurrentGpsDBQuery> {
    List<ShipCurrentGpsDO> getShipCurrentGpsAll();
    List<ShipDev> getShipDev();

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
     * 加载行次任务表数据
     * @return
     */
    public List<SailingData> querySailingInfo();



    /**
     * 加载调度计划
     * @return
     */
    public List<DispatchData> queryDispatchInfo();

    /**
     * 加载部门
     * @param map
     * @return
     */
    public List<Combox> queryDataDictInfo(@Param("pojo")Map<String, String> map);

    /**
     * 最后一次流量运价
     * @return
     */
    public List<Combox> queryContractFlowLastInfo(@Param("pojo")Map<String, String> map);


    /**
     * 根据相关条件查询实时定位数据
     * @param shipCurrentGpsQuery
     * @return
     */
    public List<ShipCurrentGpsDO> queryShipCurrentGpsInfo(@Param("pojo")ShipCurrentGpsQuery shipCurrentGpsQuery);
}
