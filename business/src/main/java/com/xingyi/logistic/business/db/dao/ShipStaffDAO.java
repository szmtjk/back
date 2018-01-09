package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.db.entity.ShipStaffDBQuery;
import com.xingyi.logistic.business.db.entity.ShipStaffDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * Created by Jadic on 2017/12/31.
 */
@Dao
public interface ShipStaffDAO extends BaseDAO<ShipStaffDO, ShipStaffDBQuery> {

}
