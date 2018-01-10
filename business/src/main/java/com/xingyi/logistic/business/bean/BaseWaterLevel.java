package com.xingyi.logistic.business.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.validation.constraints.NotNull;

public class BaseWaterLevel extends BaseModelAndDO{

    /**
     * 水位名称
     */
    @NotNullEmpty
    private String name;

    /**
     * 水位
     */
    @NotNullEmpty
    private Integer level;

    /**
     * 状态  1：启用  2：禁用
     */
    @NotNullEmpty
    @AllowedNumber(values = {1, 2}, message = "状态码错误")
    private Integer status;

    /**
     * 备注
     */
    @NotNullEmpty
    private String description;

    /**
     *
     */
    @NotNull
    private Integer isDeleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
    }
}
