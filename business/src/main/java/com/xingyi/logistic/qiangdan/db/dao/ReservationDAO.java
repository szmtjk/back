package com.xingyi.logistic.qiangdan.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDBQuery;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Dao
public interface ReservationDAO extends BaseDAO<ReservationDO,ReservationDBQuery> {

    Integer queryMyOrderInfoCnt(@Param("pojo")Map<String, Object> map);

    List<Map<String, Object>> queryMyOrderInfo(@Param("pojo")Map<String, Object> map);

    ReservationDO getAppById(@Param("id")Long userId);
}
