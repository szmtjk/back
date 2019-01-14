package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.ExamDetailReportDBQuery;
import com.szmtjk.business.model.ExamDetailReportQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExamDetailReportQueryConverter extends QueryConditionConverter<ExamDetailReportQuery, ExamDetailReportDBQuery> {

    @Override
    public ExamDetailReportDBQuery toDOCondition(ExamDetailReportQuery examDetailReportQuery) {
        ExamDetailReportDBQuery dbQuery = new ExamDetailReportDBQuery();
        if(examDetailReportQuery != null) {
            paginationConvert(examDetailReportQuery, dbQuery);
            BeanUtils.copyProperties(examDetailReportQuery, dbQuery);
        }
        return null;
    }
}
