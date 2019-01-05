package com.szmtjk.authentication.db.dao;

import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.authentication.db.entity.DataDictionaryDBQuery;
import com.szmtjk.authentication.db.entity.DataDictionaryDO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface DataDictionaryDAO extends BaseDAO<DataDictionaryDO,DataDictionaryDBQuery> {
}
