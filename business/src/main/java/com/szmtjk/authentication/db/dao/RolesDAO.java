package com.szmtjk.authentication.db.dao;

import com.szmtjk.authentication.db.entity.RolesDO;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.authentication.db.entity.RolesDBQuery;
import com.xxx.boot.jdbc.annotation.Dao;

import java.util.List;

@Dao
public interface RolesDAO extends BaseDAO<RolesDO,RolesDBQuery> {
	/**
	 * 查询某用户的角色
	 * @param userId
	 * @return
	 */
	List<RolesDO> queryByUserId(Long userId);
}
