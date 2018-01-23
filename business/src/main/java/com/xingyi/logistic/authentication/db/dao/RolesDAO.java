package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.RolesDBQuery;
import com.xingyi.logistic.authentication.db.entity.RolesDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface RolesDAO extends BaseDAO<RolesDO,RolesDBQuery> {
}
