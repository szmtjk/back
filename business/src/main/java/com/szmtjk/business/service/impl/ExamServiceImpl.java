package com.szmtjk.business.service.impl;

import com.szmtjk.business.db.entity.ExamDBQuery;
import com.szmtjk.business.db.entity.ExamDO;
import com.szmtjk.business.model.Exam;
import com.szmtjk.business.model.ExamQuery;
import com.szmtjk.business.service.ExamService;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.service.base.ModelConverter;
import com.szmtjk.business.service.base.QueryConditionConverter;
import com.szmtjk.business.service.converter.ExamConverter;
import com.szmtjk.business.service.converter.ExamQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl extends BaseCRUDService<ExamDO, Exam, ExamDBQuery, ExamQuery> implements ExamService {

    @Autowired
    private ExamConverter examConverter;

    @Autowired
    private ExamQueryConverter examQueryConverter;

    @Override
    protected ModelConverter<ExamDO, Exam> getModelConverter() {
        return examConverter;
    }

    @Override
    protected QueryConditionConverter<ExamQuery, ExamDBQuery> getConditionConverter() {
        return examQueryConverter;
    }
}
