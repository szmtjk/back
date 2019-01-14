package com.szmtjk.business.bean;

import com.szmtjk.business.bean.base.BaseModelAndDO;

import java.util.Date;

public class BaseExamCategory extends BaseModelAndDO {
    /**
     * 体检大项名称
     */
    private String name;

    /**
     * 体检报告ID
     */
    private Long examId;

    /**
     * 小结
     */
    private String summary;

    /**
     * 小结日期
     */
    private Date summaryDate;

    /**
     * 小结医生
     */
    private String summaryDoctor;

    /**
     * 数据状态
     */
    private Integer isDeleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getExamId() {
        return examId;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getSummaryDate() {
        return summaryDate;
    }

    public void setSummaryDate(Date summaryDate) {
        this.summaryDate = summaryDate;
    }

    public String getSummaryDoctor() {
        return summaryDoctor;
    }

    public void setSummaryDoctor(String summaryDoctor) {
        this.summaryDoctor = summaryDoctor;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
