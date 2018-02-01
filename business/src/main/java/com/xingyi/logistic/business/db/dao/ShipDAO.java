package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.db.entity.ShipWithStaffDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Jadic on 2017/12/31.
 */
@Dao
public interface ShipDAO extends BaseDAO<ShipDO, ShipDBQuery> {

    int queryWithStaffCount(@Param("pojo") ShipDBQuery pojo);
    List<ShipWithStaffDO> queryWithStaffList(@Param("pojo") ShipDBQuery pojo);

}
