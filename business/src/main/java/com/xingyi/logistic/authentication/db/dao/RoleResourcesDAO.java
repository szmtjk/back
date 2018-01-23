package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.RoleResourcesDBQuery;
import com.xingyi.logistic.authentication.db.entity.RoleResourcesDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface RoleResourcesDAO extends BaseDAO<RoleResourcesDO,RoleResourcesDBQuery> {
}
