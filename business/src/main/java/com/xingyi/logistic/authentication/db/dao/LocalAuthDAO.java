package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.LocalAuthDBQuery;
import com.xingyi.logistic.authentication.db.entity.LocalAuthDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface LocalAuthDAO extends BaseDAO<LocalAuthDO,LocalAuthDBQuery> {
    /**
     * 查询指定用户本地登录信息
     * @param userId
     * @return
     */
    LocalAuthDO queryByUserId(Long userId);
}
