package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.*;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * wzf
 */
@Dao
public interface ShipEventDAO extends BaseDAO<ShipEventDO, ShipEventDBQuery> {

}
