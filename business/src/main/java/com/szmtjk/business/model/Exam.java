package com.szmtjk.business.model;

import com.szmtjk.business.bean.BaseExam;
import com.szmtjk.business.util.DateUtils;

public class Exam extends BaseExam {

    public String getSummaryDateStr(){
        return DateUtils.format(this.getSummaryDate(), "yyyy-MM-dd");
    }

    public String getExamDateStr(){
        return DateUtils.format(this.getExamDate(), "yyyy-MM-dd");
    }

}
