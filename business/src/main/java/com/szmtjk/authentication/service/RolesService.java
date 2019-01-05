package com.szmtjk.authentication.service;

import com.szmtjk.authentication.model.Roles;
import com.szmtjk.authentication.model.RolesQuery;
import com.szmtjk.business.service.BaseService;

import java.util.List;

public interface RolesService extends BaseService<Roles,RolesQuery> {
	/**
	 * 查询用户角色
	 * @param userId
	 * @return
	 */
	List<Roles> queryByUserId(Long userId);
}
