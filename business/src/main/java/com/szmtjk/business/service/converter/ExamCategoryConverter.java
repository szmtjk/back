package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.ExamCategoryDO;
import com.szmtjk.business.db.entity.ExamDO;
import com.szmtjk.business.model.Exam;
import com.szmtjk.business.model.ExamCategory;
import com.szmtjk.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExamCategoryConverter extends ModelConverter<ExamCategoryDO, ExamCategory> {

    @Override
    public ExamCategoryDO toDataObject(ExamCategory examCategory) {
        ExamCategoryDO dst = new ExamCategoryDO();
        if (examCategory != null) {
            BeanUtils.copyProperties(examCategory, dst);
        }
        return dst;
    }

    @Override
    public ExamCategory toModel(ExamCategoryDO examCategoryDO) {
        ExamCategory dst = new ExamCategory();
        if (examCategoryDO != null) {
            BeanUtils.copyProperties(examCategoryDO, dst);
        }
        return dst;
    }
}
