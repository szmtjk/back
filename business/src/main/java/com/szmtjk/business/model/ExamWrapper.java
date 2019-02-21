package com.szmtjk.business.model;

import java.util.List;

public class ExamWrapper {

    private Exam exam;
    private List<ExamCategory> examCategoryList;

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public List<ExamCategory> getExamCategoryList() {
        return examCategoryList;
    }

    public void setExamCategoryList(List<ExamCategory> examCategoryList) {
        this.examCategoryList = examCategoryList;
    }
}
