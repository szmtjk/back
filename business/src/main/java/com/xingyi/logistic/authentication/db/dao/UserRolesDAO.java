package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.UserRolesDBQuery;
import com.xingyi.logistic.authentication.db.entity.UserRolesDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface UserRolesDAO extends BaseDAO<UserRolesDO,UserRolesDBQuery> {
}
