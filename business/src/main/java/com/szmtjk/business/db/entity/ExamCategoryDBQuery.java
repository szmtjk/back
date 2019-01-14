package com.szmtjk.business.db.entity;

import com.szmtjk.business.bean.base.BaseDBQueryPage;

public class ExamCategoryDBQuery extends BaseDBQueryPage {
    private Long examId;

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }
}
