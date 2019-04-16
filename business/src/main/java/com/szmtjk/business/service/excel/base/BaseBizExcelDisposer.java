package com.szmtjk.business.service.excel.base;

import com.szmtjk.business.service.BizExcelDisposer;
import com.szmtjk.business.service.excel.ExcelDisposerFactory;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Date;

public abstract class BaseBizExcelDisposer implements BizExcelDisposer {

    private static final Logger LOG = LoggerFactory.getLogger(BaseBizExcelDisposer.class);

    private DataFormatter formatter = new DataFormatter();

    @PostConstruct
    protected void init() {
        ExcelDisposerFactory.addDisposer(this);
    }

    @Override
    public JsonRet<Boolean> disposeExcel(File file) {
        if (file == null || !file.exists()) {
            LOG.warn("BaseBizExcelDisposer.disposeExcel file[{}] not exist", file);
            return JsonRet.getErrRet(ErrCode.EXCEL_FILE_NOT_EXIST);
        }
        try {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet bizSheet = workbook.getSheetAt(0);// 只获取第一个sheet作解析
            return disposeSheet(bizSheet);
        } catch (Exception e) {
            LOG.error("BaseBizExcelDisposer.disposeExcel dispose err, file:{}", file.getName(), e);
            ErrCode err = ErrCode.EXCEL_DISPOSE_ERR;
            return JsonRet.getErrRet(err.getCode(), err.getMsg() + "[" + e.getMessage() + "]");
        }
    }

    protected JsonRet<Boolean> disposeSheet(Sheet sheet) {
        if (sheet == null) {
            return JsonRet.getErrRet(ErrCode.EXCEL_FILE_NOT_EXIST);
        }
        switch (getDataType()) {
            case SIMPLE:
                sheet.forEach(row -> {
                    if (row.getRowNum() > 0) {
                        disposeSimpleRow(row);
                    }
                });
                return JsonRet.getSuccessRet(true);
            case COMPLICATED:
                return disposeComplicatedSheetData(sheet);
            default:
                break;
        }
        return JsonRet.getErrRet(ErrCode.EXCEL_DISPOSE_TYPE_NOT_MATCHED);
    }

    protected String getStrCellValue(Row row, int cellNum) {
        return formatter.formatCellValue(row.getCell(cellNum));
    }

    protected String getStrCellValue(Sheet sheet, int rowNum, int cellNum) {
        return formatter.formatCellValue(sheet.getRow(rowNum).getCell(cellNum));
    }

    protected Date getDateCellValue(Sheet sheet, int rowNum, int cellNum) {
        return sheet.getRow(rowNum).getCell(cellNum).getDateCellValue();
    }

    protected abstract JsonRet<Boolean> disposeSimpleRow(Row row);

    protected abstract JsonRet<Boolean> disposeComplicatedSheetData(Sheet sheet);
}
