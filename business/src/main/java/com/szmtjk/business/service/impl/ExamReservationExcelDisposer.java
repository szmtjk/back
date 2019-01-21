package com.szmtjk.business.service.impl;

import com.szmtjk.business.bean.excel.ExcelDataType;
import com.szmtjk.business.service.base.BaseBizExcelDisposer;
import org.apache.poi.ss.usermodel.Row;

/**
 * 体检预约信息解析
 */
public class ExamReservationExcelDisposer extends BaseBizExcelDisposer {

    @Override
    public ExcelDataType getDataType() {
        return ExcelDataType.SIMPLE;
    }

    @Override
    protected boolean disposeSimpleRow(Row row) {
        return true;
    }
}
