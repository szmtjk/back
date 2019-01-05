package com.szmtjk.authentication.bean;

import com.szmtjk.business.bean.BaseModelAndDO;

public class BaseUserRoles extends BaseModelAndDO {
    private Long userId;
    private Long roleId;
    private String roleIds;
    private Integer isDeleted;

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

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
