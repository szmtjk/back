package com.szmtjk.business.service.excel.base;

import com.szmtjk.business.service.BizExcelDisposer;
import com.szmtjk.business.service.excel.ExcelDisposerFactory;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public abstract class BaseBizExcelDisposer implements BizExcelDisposer {

    private static final Logger LOG = LoggerFactory.getLogger(BaseBizExcelDisposer.class);

    private DataFormatter formatter = new DataFormatter();

    @PostConstruct
    protected void init() {
        ExcelDisposerFactory.addDisposer(this);
    }

    @Override
    public boolean disposeExcel(File file) {
        if (file == null || !file.exists()) {
            LOG.warn("BaseBizExcelDisposer.disposeExcel file[{}] not exist", file);
            return false;
        }
        try {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet bizSheet = workbook.getSheetAt(0);// 只获取第一个sheet作解析
            return disposeSheet(bizSheet);
        } catch (IOException e) {
            LOG.error("BaseBizExcelDisposer.disposeExcel io err, file:{}", file, e);
        } catch (InvalidFormatException e) {
            LOG.error("BaseBizExcelDisposer.disposeExcel fomrat err, file:{}", file, e);
        }
        return false;
    }

    protected boolean disposeSheet(Sheet sheet) {
        if (sheet == null) {
            return false;
        }
        switch (getDataType()) {
            case SIMPLE:
                sheet.forEach(row -> {
                    if (row.getRowNum() > 0) {
                        disposeSimpleRow(row);
                    }
                });
                break;
            case COMPLICATED:
                return disposeComplicatedSheetData(sheet);
            default:
                break;
        }
        return true;
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

    protected abstract boolean disposeSimpleRow(Row row);

    protected abstract boolean disposeComplicatedSheetData(Sheet sheet);
}
