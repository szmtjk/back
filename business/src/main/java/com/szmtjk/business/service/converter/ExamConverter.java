package com.szmtjk.business.service.converter;

import com.szmtjk.business.service.base.ModelConverter;
import com.szmtjk.business.db.entity.ExamDO;
import com.szmtjk.business.model.Exam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExamConverter extends ModelConverter<ExamDO, Exam> {

    @Override
    public ExamDO toDataObject(Exam src) {
        ExamDO dst = new ExamDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public Exam toModel(ExamDO src) {
        Exam dst = new Exam();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
