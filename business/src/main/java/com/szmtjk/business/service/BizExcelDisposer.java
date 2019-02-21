package com.szmtjk.business.service;

import com.szmtjk.business.bean.excel.ExcelDataType;

import java.io.File;

public interface BizExcelDisposer {

    String EXAM_RESERVATION = "exam_reservation";
    String EXAM_REPORT = "exam_report";

    boolean disposeExcel(File excelData);

    ExcelDataType getDataType();

    String getDisposerKey();

}
