package com.szmtjk.business.model;

import com.szmtjk.business.bean.BaseExamCategory;
import com.szmtjk.business.util.DateUtils;

import java.util.List;

public class ExamCategory extends BaseExamCategory {

    List<ExamDetailReport> items;

    public String getExamDateStr(){
        return DateUtils.format(this.getSummaryDate(), "yyyy-MM-dd");
    }

    public List<ExamDetailReport> getItems() {
        return items;
    }

    public void setItems(List<ExamDetailReport> items) {
        this.items = items;
    }
}
