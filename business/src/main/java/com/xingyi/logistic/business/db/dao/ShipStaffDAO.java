package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.*;
import com.xingyi.logistic.business.model.ShipCurrentGpsQuery;
import com.xingyi.logistic.business.model.ShipStaff;
import com.xingyi.logistic.business.model.ShipStaffQuery;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Jadic on 2017/12/31.
 */
@Dao
public interface ShipStaffDAO extends BaseDAO<ShipStaffDO, ShipStaffDBQuery> {
     int judege(@Param("pojo")ShipStaff shipStaff);
}
