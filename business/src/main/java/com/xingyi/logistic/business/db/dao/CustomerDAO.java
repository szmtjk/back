package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerDO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 客户信息
 */
@Dao
public interface CustomerDAO extends BaseDAO<CustomerDO, CustomerDBQuery> {

}
