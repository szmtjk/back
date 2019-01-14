package com.szmtjk.business.model;

import com.szmtjk.business.bean.base.BaseQueryPage;

public class ExamCategoryQuery extends BaseQueryPage {
    private Long examId;

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }
}
