package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;

import com.xingyi.logistic.business.db.entity.WaterLevelDBQuery;
import com.xingyi.logistic.business.db.entity.WaterLevelDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * Created by Jadic on 2017/12/31.
 */
@Dao
public interface WaterLevelDAO extends BaseDAO<WaterLevelDO, WaterLevelDBQuery> {

    WaterLevelDO getByName(String name);
}
