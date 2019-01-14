package com.szmtjk.business.service.impl;

import com.szmtjk.business.db.entity.ExamCategoryDBQuery;
import com.szmtjk.business.db.entity.ExamCategoryDO;
import com.szmtjk.business.model.ExamCategory;
import com.szmtjk.business.model.ExamCategoryQuery;
import com.szmtjk.business.service.ExamCategoryService;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.service.base.ModelConverter;
import com.szmtjk.business.service.base.QueryConditionConverter;
import com.szmtjk.business.service.converter.ExamCategoryConverter;
import com.szmtjk.business.service.converter.ExamCategoryQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamCategoryServiceImpl extends BaseCRUDService<ExamCategoryDO, ExamCategory, ExamCategoryDBQuery, ExamCategoryQuery> implements ExamCategoryService {

    @Autowired
    private ExamCategoryConverter examCategoryConverter;

    @Autowired
    private ExamCategoryQueryConverter examCategoryQueryConverter;

    @Override
    protected ModelConverter<ExamCategoryDO, ExamCategory> getModelConverter() {
        return examCategoryConverter;
    }

    @Override
    protected QueryConditionConverter<ExamCategoryQuery, ExamCategoryDBQuery> getConditionConverter() {
        return examCategoryQueryConverter;
    }
}
