package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.*;
import com.xingyi.logistic.business.model.ShipOil;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wzf on 2017/12/31.
 */
@Dao
public interface ShipOilDAO extends BaseDAO<ShipOilDO, ShipOilDBQuery> {

    List<ShipOilDO> calculateRemainingOil(ShipOilDO shipOilDO);


}
