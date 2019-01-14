package com.szmtjk.business.model;

import com.szmtjk.business.bean.BaseExamCategory;

import java.util.List;

public class ExamCategory extends BaseExamCategory {

    List<ExamDetailReport> items;

    public List<ExamDetailReport> getItems() {
        return items;
    }

    public void setItems(List<ExamDetailReport> items) {
        this.items = items;
    }
}
