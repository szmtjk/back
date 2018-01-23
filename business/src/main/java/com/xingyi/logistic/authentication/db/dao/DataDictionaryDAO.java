package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.DataDictionaryDBQuery;
import com.xingyi.logistic.authentication.db.entity.DataDictionaryDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface DataDictionaryDAO extends BaseDAO<DataDictionaryDO,DataDictionaryDBQuery>{
}
