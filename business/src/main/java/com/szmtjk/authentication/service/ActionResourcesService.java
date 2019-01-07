package com.szmtjk.authentication.service;

import com.szmtjk.authentication.model.ActionResources;
import com.szmtjk.authentication.model.ActionResourcesQuery;
import com.szmtjk.business.service.base.BaseService;

import java.util.List;
import java.util.Map;

public interface ActionResourcesService extends BaseService<ActionResources,ActionResourcesQuery>{
	/**
	 * 查询用户权限
	 * @param userId
	 * @return
	 */
	List<ActionResources> queryByUserId(Long userId);

	/**
	 * 加载权限树
	 * @return
     */
	List<Map<String, Object >> queryTreeResourcesInfo();
}
