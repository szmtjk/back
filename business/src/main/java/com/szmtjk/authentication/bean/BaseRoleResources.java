package com.szmtjk.authentication.bean;

import com.szmtjk.business.bean.base.BaseModelAndDO;

public class BaseRoleResources extends BaseModelAndDO {
    private Long roleId;
    private Long resourceId;
    private Integer isDeleted;
    private String pids;

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
