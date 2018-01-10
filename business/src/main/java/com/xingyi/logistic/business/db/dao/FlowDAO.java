package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.FlowDO;
import com.xingyi.logistic.business.db.entity.FlowDBQuery;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 流向信息
 */
@Dao
public interface FlowDAO extends BaseDAO<FlowDO, FlowDBQuery> {

}
