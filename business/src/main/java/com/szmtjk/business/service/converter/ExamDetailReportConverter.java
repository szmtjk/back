package com.szmtjk.business.service.converter;

import com.szmtjk.business.db.entity.ExamDetailReportDO;
import com.szmtjk.business.model.ExamDetailReport;
import com.szmtjk.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ExamDetailReportConverter extends ModelConverter<ExamDetailReportDO, ExamDetailReport> {
    @Override
    public ExamDetailReportDO toDataObject(ExamDetailReport examDetailReport) {
        ExamDetailReportDO dst = new ExamDetailReportDO();
        if(examDetailReport != null) {
            BeanUtils.copyProperties(examDetailReport, dst);
        }
        return dst;
    }

    @Override
    public ExamDetailReport toModel(ExamDetailReportDO data) {
        ExamDetailReport dst = new ExamDetailReport();
        if(data != null) {
            BeanUtils.copyProperties(data, dst);
        }
        return dst;
    }
}
