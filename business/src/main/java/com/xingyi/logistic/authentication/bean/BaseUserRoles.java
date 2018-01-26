package com.xingyi.logistic.authentication.bean;

import com.xingyi.logistic.business.bean.BaseModelAndDO;

public class BaseUserRoles extends BaseModelAndDO{
    private Long userId;
    private Long roleId;
    private Integer isDeleted;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
