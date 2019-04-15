package com.szmtjk.business.service.excel;

import com.szmtjk.business.model.ExamReservation;
import com.szmtjk.business.service.ExamReservationService;
import com.szmtjk.business.service.excel.base.BaseSimpleBizExcelDisposer;
import com.szmtjk.business.util.BizUtil;
import com.szmtjk.business.util.ExcelUtil;
import com.xxx.common.bean.JsonRet;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 体检预约信息解析
 */
@Service
public class ExamReservationExcelDisposer extends BaseSimpleBizExcelDisposer {

    @Autowired
    private ExamReservationService examReservationService;

    @Override
    protected JsonRet<Boolean> disposeSimpleRow(Row row) {
        ExamReservation examReservation = new ExamReservation();
        int cellIndex = 0;
        examReservation.setName(ExcelUtil.getStrValue(row, cellIndex ++));
        examReservation.setGender(BizUtil.getGender(ExcelUtil.getStrValue(row, cellIndex ++)));
        examReservation.setIdNo(ExcelUtil.getStrValue(row, cellIndex ++));
        examReservation.setMobile(ExcelUtil.getStrValue(row, cellIndex ++));
        examReservation.setMarried(BizUtil.getIfMarried(ExcelUtil.getStrValue(row, cellIndex ++)));
        examReservation.setCompany(ExcelUtil.getStrValue(row, cellIndex ++));
        examReservation.setPackageName(ExcelUtil.getStrValue(row, cellIndex ++));
        examReservation.setExamDate(ExcelUtil.getStrValue(row, cellIndex ++));
        examReservation.setMemo(ExcelUtil.getStrValue(row, cellIndex ++));
        JsonRet<Long> addRet = examReservationService.add(examReservation);
        return JsonRet.getSuccessRet(addRet.isSuccess());
    }

    @Override
    public String getDisposerKey() {
        return EXAM_RESERVATION;
    }
}
