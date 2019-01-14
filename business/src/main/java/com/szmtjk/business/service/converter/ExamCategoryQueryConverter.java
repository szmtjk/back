package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.ExamCategoryDBQuery;
import com.szmtjk.business.model.ExamCategoryQuery;
import com.szmtjk.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExamCategoryQueryConverter extends QueryConditionConverter<ExamCategoryQuery, ExamCategoryDBQuery> {

    @Override
    public ExamCategoryDBQuery toDOCondition(ExamCategoryQuery examCategoryQuery) {
        ExamCategoryDBQuery examCategoryDBQuery = new ExamCategoryDBQuery();
        if (examCategoryQuery != null) {
            paginationConvert(examCategoryQuery, examCategoryDBQuery);
            BeanUtils.copyProperties(examCategoryQuery, examCategoryDBQuery);
        }
        return examCategoryDBQuery;
    }
}
