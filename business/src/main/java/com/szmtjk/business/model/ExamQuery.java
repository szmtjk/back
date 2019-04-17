package com.szmtjk.business.model;

import com.szmtjk.business.bean.base.BaseQueryPage;

public class ExamQuery extends BaseQueryPage {
    /**
     * 体检人ID
     */
    private Long userId;

    /**
     * 体检报告编号
     */
    private String examNo;
    private String fullName;
    private String mobile;
    private Integer gender;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
