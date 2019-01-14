package com.szmtjk.business.db.entity;

import com.szmtjk.business.bean.base.BaseDBQueryPage;

public class ExamDetailReportDBQuery extends BaseDBQueryPage {
    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
