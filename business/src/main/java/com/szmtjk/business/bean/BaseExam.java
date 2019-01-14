package com.szmtjk.business.bean;

import com.szmtjk.business.bean.base.BaseModelAndDO;

import java.util.Date;

public class BaseExam extends BaseModelAndDO {
    /**
     * 体检人ID
     */
    private Long userId;

    /**
     * 体检日期
     */
    private Date examDate;

    /**
     * 体检报告编号
     */
    private String examNo;

    /**
     * 体检人姓名
     */
    private String fullName;

    /**
     * 体检人年龄
     */
    private int age;

    /**
     * 体检人公司
     */
    private String company;

    /**
     * 总检内容
     */
    private String summary;

    /**
     * 总检医生
     */
    private String summaryDoctor;

    /**
     * 总检日期
     */
    private Date summaryDate;

    /**
     * 是否已删除
     */
    private Integer isDeleted;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummaryDoctor() {
        return summaryDoctor;
    }

    public void setSummaryDoctor(String summaryDoctor) {
        this.summaryDoctor = summaryDoctor;
    }

    public Date getSummaryDate() {
        return summaryDate;
    }

    public void setSummaryDate(Date summaryDate) {
        this.summaryDate = summaryDate;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
