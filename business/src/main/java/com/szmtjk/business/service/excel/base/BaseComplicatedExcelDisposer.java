package com.szmtjk.business.service.excel.base;

import com.szmtjk.business.bean.excel.ExcelDataType;
import org.apache.poi.ss.usermodel.Row;

public abstract class BaseComplicatedExcelDisposer extends BaseBizExcelDisposer {

    @Override
    protected boolean disposeSimpleRow(Row row) {
        return false;
    }

    @Override
    public ExcelDataType getDataType() {
        return ExcelDataType.COMPLICATED;
    }
}
