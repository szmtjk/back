package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.db.entity.WaterLevelDBQuery;
import com.xingyi.logistic.business.db.entity.WaterLevelDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

/**
 * 水位
 */
@Dao
public interface WaterLevelDAO extends BaseDAO<WaterLevelDO, WaterLevelDBQuery> {

}
