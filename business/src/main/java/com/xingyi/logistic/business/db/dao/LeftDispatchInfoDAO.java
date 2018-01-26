package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDBQuery;
import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 余量临调信息
 */
@Dao
public interface LeftDispatchInfoDAO extends BaseDAO<LeftDispatchInfoDO,LeftDispatchInfoDBQuery>{
}
