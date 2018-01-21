package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskDO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 客户任务流向
 */
@Dao
public interface CustomerTaskFlowDAO extends BaseDAO<CustomerTaskFlowDO, CustomerTaskFlowDBQuery> {
}
