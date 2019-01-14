package com.szmtjk.business.model;

import com.szmtjk.business.bean.base.BaseQueryPage;

public class ExamDetailReportQuery extends BaseQueryPage {
    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
