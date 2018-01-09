package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ContractDBQuery;
import com.xingyi.logistic.business.db.entity.ContractDO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 合同信息
 */
@Dao
public interface ContractDAO extends BaseDAO<ContractDO, ContractDBQuery> {

}
