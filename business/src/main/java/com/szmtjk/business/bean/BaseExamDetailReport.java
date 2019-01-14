package com.szmtjk.business.bean;

import com.szmtjk.business.bean.base.BaseModelAndDO;

public class BaseExamDetailReport extends BaseModelAndDO {

    /**
     * 所属体检大项
     */
    private Long categoryId;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 单位
     */
    private String itemUnit;

    /**
     * 检查结果
     */
    private String result;

    /**
     * 参考范围
     */
    private String referenceRange;

    /**
     * 提示
     */
    private String tip;

    /**
     * 数据状态
     */
    private Integer isDeleted;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReferenceRange() {
        return referenceRange;
    }

    public void setReferenceRange(String referenceRange) {
        this.referenceRange = referenceRange;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
