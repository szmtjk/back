package com.szmtjk.business.service.excel.base;

import com.szmtjk.business.bean.excel.ExcelDataType;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.apache.poi.ss.usermodel.Row;

public abstract class BaseComplicatedExcelDisposer extends BaseBizExcelDisposer {

    @Override
    protected JsonRet<Boolean> disposeSimpleRow(Row row) {
        return JsonRet.getErrRet(ErrCode.EXCEL_DISPOSE_TYPE_NOT_MATCHED);
    }

    @Override
    public ExcelDataType getDataType() {
        return ExcelDataType.COMPLICATED;
    }
}
