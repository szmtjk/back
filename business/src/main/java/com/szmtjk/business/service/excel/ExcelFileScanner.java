package com.szmtjk.business.service.excel;

import com.szmtjk.business.model.FileImportStatus;
import com.szmtjk.business.service.BizExcelDisposer;
import com.szmtjk.business.service.FileImportStatusService;
import com.szmtjk.business.util.DateUtils;
import com.szmtjk.business.util.ZipUtil;
import com.xxx.common.bean.JsonRet;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collection;
import java.util.Random;

/**
 * excel文件自动扫描器，扫描器工作原理：
 * 1. 扫描指定的体检报告zip压缩文件目录，遍历所有zip文件并解压至指定excel文件目录，成功后，删除zip文件
 * 2. 扫描指定excel文件目录，遍历所有excel文件并解析
 *    2.1 对于解压成功后的excel文件直接删除
 *    2.2 对于解压失败后的excel文件移除至指定错误目录
 */
@Service
public class ExcelFileScanner {

    private static final Logger LOG = LoggerFactory.getLogger(ExcelFileScanner.class);

    @Value("${excel.reservation.zipUploadDir}")
    private String reservationExcelZipUploadDir;

    @Value("${excel.reservation.unzippedDir}")
    private String reservationExcelUnzippedDir;

    @Value("${excel.reservation.invalidFileDir}")
    private String reservationInvalidExcelFileDir;

    @Value("${excel.report.zipUploadDir}")
    private String reportExcelZipUploadDir;

    @Value("${excel.report.unzippedDir}")
    private String reportExcelUnzippedDir;

    @Value("${excel.report.invalidFileDir}")
    private String reportInvalidExcelFileDir;

    @Autowired
    private FileImportStatusService fileImportStatusService;

    private static final String[] ZIP = new String[]{"zip"};
    private static final String[] EXCEL = new String[]{"xls", "xlsx"};


    @Scheduled(fixedRate = 1000, initialDelay = 3000L)
    public void scanAndUnzip() {
        loopZipFilesAndUnzip(reservationExcelZipUploadDir, reservationExcelUnzippedDir);
        loopZipFilesAndUnzip(reportExcelZipUploadDir, reportExcelUnzippedDir);
    }

    private void loopZipFilesAndUnzip(String zipFileDir, String unzippedDir) {
        try {
            File zipUploadDir = new File(zipFileDir);
            if (!zipUploadDir.exists() || !zipUploadDir.isDirectory()) {
                LOG.warn("Zip Upload Dir[{}] is not exists", zipFileDir);
                return;
            }
            Collection<File> zipFiles = FileUtils.listFiles(zipUploadDir, ZIP, false);
            for (File zipFile : zipFiles) {
                ZipUtil.unzipAllFilesAndAddPrefix(zipFile.getAbsolutePath(), unzippedDir, getBatchNo() + "_");
                FileUtils.forceDelete(zipFile);
            }
        } catch (Exception e) {
            LOG.error("ExcelFileScanner.loopZipFilesAndUnzip err, zipFileDir:{}, unzippedDir:{}", zipFileDir, unzippedDir, e);
        }
    }

    private String getBatchNo() {
        return DateUtils.getCurrentSystemTime("yyyyMMddHHmmss") + new Random().nextInt(10);
    }

    @Scheduled(fixedRate = 1000, initialDelay = 3000L)
    public void scanAndDisposeExcel() {
        loopExcelFilesAndDispose(reservationExcelUnzippedDir, reservationInvalidExcelFileDir, BizExcelDisposer.EXAM_RESERVATION);
        loopExcelFilesAndDispose(reportExcelUnzippedDir, reportInvalidExcelFileDir, BizExcelDisposer.EXAM_REPORT);
    }

    private void loopExcelFilesAndDispose(String excelDir, String invalidFileDir, String disposeKey) {
        BizExcelDisposer excelDisposer = ExcelDisposerFactory.getExcelDisposer(disposeKey);
        if (excelDisposer == null) {
            return;
        }
        try {
            File excelFolder = new File(excelDir);
            if (!excelFolder.exists() || !excelFolder.isDirectory()) {
                LOG.warn("Excel Dir[{}] is not exists", excelDir);
                return;
            }
            File invalidFileFolder = new File(invalidFileDir);
            Collection<File> excelFiles = FileUtils.listFiles(excelFolder, EXCEL, false);
            for (File excel : excelFiles) {
                FileImportStatus fileImportStatus = createFileImportStatus(excel, disposeKey);
                JsonRet<Boolean> disposeRet = excelDisposer.disposeExcel(excel);
                if (disposeRet.isSuccess()) {
                    LOG.info("succeed to dispose:{}", excel.getName());
                    FileUtils.forceDelete(excel);
                    fileImportStatus.setStatus(20);
                } else {//if fail, move the excel to invalid dir
                    LOG.info("fail to dispose:{}, move to:{}", excel.getName(), invalidFileDir);
                    FileUtils.moveFileToDirectory(excel, invalidFileFolder, true);
                    fileImportStatus.setStatus(30);
                    fileImportStatus.setTip(disposeRet.getMsg());
                }
                fileImportStatusService.add(fileImportStatus);
            }
        } catch (Exception e) {
            LOG.error("ExcelFileScanner.loopExcelFilesAndDispose, excelDir:{}, invalidFileDir:{}, disposeKey:{}", excelDir, invalidFileDir, disposeKey, e);
        }
    }

    private FileImportStatus createFileImportStatus(File excel, String fileType) {
        FileImportStatus fileImportStatus = new FileImportStatus();
        fileImportStatus.setBizType(0);
        int splitterIndex = excel.getName().indexOf("_");
        if (splitterIndex > 0) {
            fileImportStatus.setFileName(excel.getName().substring(splitterIndex + 1));
            fileImportStatus.setFileNo(excel.getName().substring(0, splitterIndex));
        } else {
            fileImportStatus.setFileName(excel.getName());
        }
        if (BizExcelDisposer.EXAM_RESERVATION.equals(fileType)) {
            fileImportStatus.setBizType(1);
        } else if (BizExcelDisposer.EXAM_REPORT.equals(fileType)) {
            fileImportStatus.setBizType(2);
        }
        return fileImportStatus;
    }
}
