package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * Created by Jadic on 2017/12/31.
 */
@Dao
public interface ShipDAO extends BaseDAO<ShipDO, ShipDBQuery> {

}
