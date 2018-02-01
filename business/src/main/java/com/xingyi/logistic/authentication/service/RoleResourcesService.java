package com.xingyi.logistic.authentication.service;

import com.xingyi.logistic.authentication.model.RoleResources;
import com.xingyi.logistic.authentication.model.RoleResourcesQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.JsonRet;

import java.util.List;
import java.util.Map;

public interface RoleResourcesService extends BaseService<RoleResources,RoleResourcesQuery> {
    /**
     * 删除指定角色的权限
     * @param roleId
     */
    void deleteByRoleId(Long roleId);

    /**
     * 分配角色权限
     * @param model
     * @return
     */
    JsonRet<Boolean> addfly(RoleResources model);

    /**
     * 根据角色ID来加载权限
     * @param map
     * @return
     */
    List<Map<String, Object>> queryResourceByRoleInfo(Map<String, Object> map);
}
