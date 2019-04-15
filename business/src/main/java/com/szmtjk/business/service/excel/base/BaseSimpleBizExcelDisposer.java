package com.szmtjk.business.service.excel.base;

import com.szmtjk.business.bean.excel.ExcelDataType;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.apache.poi.ss.usermodel.Sheet;

public abstract class BaseSimpleBizExcelDisposer extends BaseBizExcelDisposer {

    @Override
    protected JsonRet<Boolean> disposeComplicatedSheetData(Sheet sheet) {
        return JsonRet.getErrRet(ErrCode.EXCEL_DISPOSE_TYPE_NOT_MATCHED);
    }

    @Override
    public ExcelDataType getDataType() {
        return ExcelDataType.SIMPLE;
    }
}
