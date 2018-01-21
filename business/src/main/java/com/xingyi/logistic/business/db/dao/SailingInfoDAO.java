package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskDO;
import com.xingyi.logistic.business.db.entity.SailingInfoDBQuery;
import com.xingyi.logistic.business.db.entity.SailingInfoDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 航次信息
 */
@Dao
public interface SailingInfoDAO extends BaseDAO<SailingInfoDO, SailingInfoDBQuery> {
}
