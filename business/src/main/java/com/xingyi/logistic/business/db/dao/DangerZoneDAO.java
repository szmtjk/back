package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.DangerZoneDBQuery;
import com.xingyi.logistic.business.db.entity.DangerZoneDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 危险区域
 */
@Dao
public interface DangerZoneDAO extends BaseDAO<DangerZoneDO, DangerZoneDBQuery> {

}
