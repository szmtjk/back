package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.ActionResourcesDBQuery;
import com.xingyi.logistic.authentication.db.entity.ActionResourcesDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface ActionResourcesDAO extends BaseDAO<ActionResourcesDO,ActionResourcesDBQuery>{
}
