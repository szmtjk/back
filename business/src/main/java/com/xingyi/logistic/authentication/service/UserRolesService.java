package com.xingyi.logistic.authentication.service;

import com.xingyi.logistic.authentication.model.UserRoles;
import com.xingyi.logistic.authentication.model.UserRolesQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.JsonRet;

import java.util.List;
import java.util.Map;

public interface UserRolesService extends BaseService<UserRoles,UserRolesQuery> {
    /**
     * 删除指定用户的角色配置
     * @param userId
     */
    void deleteByUserId(Long userId);

    int setRoles(Long userId, List<Long> roleIds);

    /**
     * 设置用户角色
     * @param model
     * @return
     */
    JsonRet<Boolean> addfly(UserRoles model);

    /**
     * 根据用户加载角色ID
     * @param map
     * @return
     */
    List<Map<String, Object>> queryRolesByUserIdInfo(Map<String, Object> map);
}
