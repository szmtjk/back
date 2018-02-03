package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.TempDispatchShipDBQuery;
import com.xingyi.logistic.business.db.entity.TempDispatchShipDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

/**
 * 临调船舶
 */
@Dao
public interface TempDispatchShipDAO extends BaseDAO<TempDispatchShipDO, TempDispatchShipDBQuery> {

    TempDispatchShipDO getAppById(@Param("id") Long userId);
}
