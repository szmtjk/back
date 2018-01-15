package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.DangerZoneDBQuery;
import com.xingyi.logistic.business.db.entity.DangerZoneDO;
import com.xingyi.logistic.business.db.entity.DangerZoneSpeedDBQuery;
import com.xingyi.logistic.business.db.entity.DangerZoneSpeedDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 危险区域速度
 */
@Dao
public interface DangerZoneSpeedDAO extends BaseDAO<DangerZoneSpeedDO, DangerZoneSpeedDBQuery> {

}
