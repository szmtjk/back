package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipCurrentGpsDBQuery;
import com.xingyi.logistic.business.db.entity.ShipCurrentGpsDO;
import com.xingyi.logistic.business.model.*;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by WCL on 2018/1/12.
 */
@Dao
public interface ShipCurrentGpsDAO extends BaseDAO<ShipCurrentGpsDO, ShipCurrentGpsDBQuery> {
    List<ShipCurrentGpsDO> getShipCurrentGpsAll();
    List<ShipDev> getShipDev();

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
    public List<ShipCurrentGpsDO> queryShipCurrentGpsInfo(@Param("pojo")ShipCurrentGpsQuery shipCurrentGpsQuery);
}
