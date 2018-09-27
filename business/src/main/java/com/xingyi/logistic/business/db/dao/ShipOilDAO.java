package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.*;
import com.xingyi.logistic.business.model.ShipOil;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by wzf on 2017/12/31.
 */
@Dao
public interface ShipOilDAO extends BaseDAO<ShipOilDO, ShipOilDBQuery> {

    int calculateRemainingOilCount(@Param("pojo")ShipOilDBQuery pojo);

    List<Map<String, Object>> calculateRemainingOil(@Param("pojo")ShipOilDBQuery pojo);


}
