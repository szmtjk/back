package com.szmtjk.qiangdan.db.dao;

import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.qiangdan.db.entity.AppUserDBQuery;
import com.szmtjk.qiangdan.db.entity.AppUserDO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface AppUserDAO extends BaseDAO<AppUserDO,AppUserDBQuery> {
}
