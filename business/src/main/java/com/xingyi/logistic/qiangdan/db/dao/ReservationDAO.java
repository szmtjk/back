package com.xingyi.logistic.qiangdan.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDBQuery;
import com.xingyi.logistic.qiangdan.db.entity.ReservationDO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface ReservationDAO extends BaseDAO<ReservationDO,ReservationDBQuery> {
}
