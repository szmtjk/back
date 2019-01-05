package com.szmtjk.business.db.dao;

import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.db.entity.OperationLogDBQuery;
import com.szmtjk.business.db.entity.OperationLogDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * Created by xiaohu on 2018/8/25.
 */
@Dao
public interface OperationLogDAO extends BaseDAO<OperationLogDO, OperationLogDBQuery> {
}
