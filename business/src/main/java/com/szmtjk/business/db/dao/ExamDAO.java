package com.szmtjk.business.db.dao;

import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.db.entity.ExamDBQuery;
import com.szmtjk.business.db.entity.ExamDO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface ExamDAO extends BaseDAO<ExamDO, ExamDBQuery> {
}
