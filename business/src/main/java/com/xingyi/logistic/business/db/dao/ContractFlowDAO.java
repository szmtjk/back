package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ContractDBQuery;
import com.xingyi.logistic.business.db.entity.ContractDO;
import com.xingyi.logistic.business.db.entity.ContractFlowDBQuery;
import com.xingyi.logistic.business.db.entity.ContractFlowDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 合同流向
 */
@Dao
public interface ContractFlowDAO extends BaseDAO<ContractFlowDO, ContractFlowDBQuery> {

}
