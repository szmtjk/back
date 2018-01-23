package com.xingyi.logistic.authentication.service;

import com.xingyi.logistic.authentication.model.Roles;
import com.xingyi.logistic.authentication.model.RolesQuery;
import com.xingyi.logistic.business.service.BaseService;

import java.util.List;

public interface RolesService extends BaseService<Roles,RolesQuery> {
	/**
	 * 查询用户角色
	 * @param userId
	 * @return
	 */
	List<Roles> queryByUserId(Long userId);
}
