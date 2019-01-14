package com.szmtjk.business.db.dao;

import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.db.entity.ExamCategoryDBQuery;
import com.szmtjk.business.db.entity.ExamCategoryDO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface ExamCategoryDAO extends BaseDAO<ExamCategoryDO, ExamCategoryDBQuery> {
}
