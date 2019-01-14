package com.szmtjk.business.service.impl;

import com.szmtjk.business.db.entity.ExamDetailReportDBQuery;
import com.szmtjk.business.db.entity.ExamDetailReportDO;
import com.szmtjk.business.model.ExamDetailReport;
import com.szmtjk.business.model.ExamDetailReportQuery;
import com.szmtjk.business.service.ExamDetailReportService;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.service.base.ModelConverter;
import com.szmtjk.business.service.base.QueryConditionConverter;
import com.szmtjk.business.service.converter.ExamDetailReportConverter;
import com.szmtjk.business.service.converter.ExamDetailReportQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamDetailReportServiceImpl extends BaseCRUDService<ExamDetailReportDO, ExamDetailReport, ExamDetailReportDBQuery, ExamDetailReportQuery> implements ExamDetailReportService {

    @Autowired
    private ExamDetailReportConverter examDetailReportConverter;

    @Autowired
    private ExamDetailReportQueryConverter examDetailReportQueryConverter;

    @Override
    protected ModelConverter<ExamDetailReportDO, ExamDetailReport> getModelConverter() {
        return examDetailReportConverter;
    }

    @Override
    protected QueryConditionConverter<ExamDetailReportQuery, ExamDetailReportDBQuery> getConditionConverter() {
        return examDetailReportQueryConverter;
    }
}
