package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.LocalAuthDBQuery;
import com.xingyi.logistic.authentication.db.entity.LocalAuthDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface LocalAuthDAO extends BaseDAO<LocalAuthDO,LocalAuthDBQuery> {
}
