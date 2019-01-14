package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.ExamDBQuery;
import com.szmtjk.business.model.ExamQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExamQueryConverter extends QueryConditionConverter<ExamQuery, ExamDBQuery> {
    @Override
    public ExamDBQuery toDOCondition(ExamQuery examQuery) {
        ExamDBQuery exam = new ExamDBQuery();
        if (examQuery != null) {
            paginationConvert(examQuery, exam);
            BeanUtils.copyProperties(examQuery, exam);
        }
        return exam;
    }
}
