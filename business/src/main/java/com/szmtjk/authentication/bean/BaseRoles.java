package com.szmtjk.authentication.bean;

import com.szmtjk.business.bean.base.BaseModelAndDO;

public class BaseRoles extends BaseModelAndDO {
    private String code;
    private String name;
    private String remark;
    private Integer isDeleted;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
