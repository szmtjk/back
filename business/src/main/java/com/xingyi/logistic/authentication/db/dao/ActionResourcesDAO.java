package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.ActionResourcesDBQuery;
import com.xingyi.logistic.authentication.db.entity.ActionResourcesDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

import java.util.List;

@Dao
public interface ActionResourcesDAO extends BaseDAO<ActionResourcesDO,ActionResourcesDBQuery>{
	/**
	 * 查询用户操作权限
	 * @param userId
	 * @return
	 */
	List<ActionResourcesDO> queryByUserId(Long userId);
}
