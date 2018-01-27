package com.xingyi.logistic.qiangdan.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.qiangdan.db.entity.AppUserDBQuery;
import com.xingyi.logistic.qiangdan.db.entity.AppUserDO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface AppUserDAO extends BaseDAO<AppUserDO,AppUserDBQuery>{
}
