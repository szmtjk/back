package com.szmtjk.business.model;

import com.szmtjk.business.bean.BaseExam;
import com.szmtjk.business.util.DateUtils;

public class Exam extends BaseExam {

    @Override
    public String getSummary() {
        String summary = super.getSummary();
        return summary == null ? summary : summary.replaceAll("\n", "<br/>");
    }

    public String getSummaryDateStr(){
        return DateUtils.format(this.getSummaryDate(), "yyyy-MM-dd");
    }

    public String getExamDateStr(){
        return DateUtils.format(this.getExamDate(), "yyyy-MM-dd");
    }

}
