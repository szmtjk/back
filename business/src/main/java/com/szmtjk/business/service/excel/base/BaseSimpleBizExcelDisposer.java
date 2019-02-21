package com.szmtjk.business.service.excel.base;

import com.szmtjk.business.bean.excel.ExcelDataType;
import org.apache.poi.ss.usermodel.Sheet;

public abstract class BaseSimpleBizExcelDisposer extends BaseBizExcelDisposer {

    @Override
    protected boolean disposeComplicatedSheetData(Sheet sheet) {
        return false;
    }

    @Override
    public ExcelDataType getDataType() {
        return ExcelDataType.SIMPLE;
    }
}
