package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.OAuthDBQuery;
import com.xingyi.logistic.authentication.db.entity.OAuthDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface OAuthDAO extends BaseDAO<OAuthDO,OAuthDBQuery> {
}
