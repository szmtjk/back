package com.xingyi.logistic.authentication.service;

import com.xingyi.logistic.authentication.model.UserRoles;
import com.xingyi.logistic.authentication.model.UserRolesQuery;
import com.xingyi.logistic.business.service.BaseService;

import java.util.List;

public interface UserRolesService extends BaseService<UserRoles,UserRolesQuery> {
    /**
     * 删除指定用户的角色配置
     * @param userId
     */
    void deleteByUserId(Long userId);

    int setRoles(Long userId, List<Long> roleIds);
}
