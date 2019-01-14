package com.szmtjk.web.controller;

import com.szmtjk.business.model.ExamDetailReport;
import com.szmtjk.business.model.ExamDetailReportQuery;
import com.szmtjk.web.controller.base.BaseCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("examDetailReport")
public class ExamDetailReportController extends BaseCRUDController<ExamDetailReport, ExamDetailReportQuery> {
}
