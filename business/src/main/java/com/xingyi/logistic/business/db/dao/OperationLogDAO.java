package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.OperationLogDBQuery;
import com.xingyi.logistic.business.db.entity.OperationLogDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * Created by xiaohu on 2018/8/25.
 */
@Dao
public interface OperationLogDAO extends BaseDAO<OperationLogDO, OperationLogDBQuery> {
}
