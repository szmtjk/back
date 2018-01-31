package com.xingyi.logistic.authentication.service;

import com.xingyi.logistic.authentication.model.RoleResources;
import com.xingyi.logistic.authentication.model.RoleResourcesQuery;
import com.xingyi.logistic.business.service.BaseService;

public interface RoleResourcesService extends BaseService<RoleResources,RoleResourcesQuery> {
    /**
     * 删除指定角色的权限
     * @param roleId
     */
    void deleteByRoleId(Long roleId);
}
