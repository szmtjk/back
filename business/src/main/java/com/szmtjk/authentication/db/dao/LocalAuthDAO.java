package com.szmtjk.authentication.db.dao;

import com.szmtjk.authentication.db.entity.LocalAuthDO;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.authentication.db.entity.LocalAuthDBQuery;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface LocalAuthDAO extends BaseDAO<LocalAuthDO,LocalAuthDBQuery> {
    /**
     * 查询指定用户本地登录信息
     * @param userId
     * @return
     */
    LocalAuthDO queryByUserId(Long userId);

    LocalAuthDO queryByUserName(String userName);
}
