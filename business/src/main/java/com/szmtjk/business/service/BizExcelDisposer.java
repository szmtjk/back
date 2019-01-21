package com.szmtjk.business.service;

import com.szmtjk.business.bean.excel.ExcelDataType;

import java.io.File;

public interface BizExcelDisposer<T> {

    boolean disposeExcel(File excelData);

    ExcelDataType getDataType();

}
