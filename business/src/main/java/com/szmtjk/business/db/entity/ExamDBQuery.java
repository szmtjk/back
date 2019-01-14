package com.szmtjk.business.db.entity;

import com.szmtjk.business.bean.base.BaseDBQueryPage;

public class ExamDBQuery extends BaseDBQueryPage {
    /**
     * 体检人ID
     */
    private Long userId;

    /**
     * 体检报告编号
     */
    private String examNo;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getExamNo() {
        return examNo;
    }

    public void setExamNo(String examNo) {
        this.examNo = examNo;
    }
}
