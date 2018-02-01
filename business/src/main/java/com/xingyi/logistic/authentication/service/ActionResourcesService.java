package com.xingyi.logistic.authentication.service;

import com.xingyi.logistic.authentication.model.ActionResources;
import com.xingyi.logistic.authentication.model.ActionResourcesQuery;
import com.xingyi.logistic.business.service.BaseService;

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
