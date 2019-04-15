package com.szmtjk.business.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public class ZipUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ZipUtil.class);

    public static void unzipAllFiles(String zipFilePath, String dstUnzipDir) {
        unzipAllFilesAndAddPrefix(zipFilePath, dstUnzipDir, null);
    }

    public static void unzipAllFilesAndAddPrefix(String zipFilePath, String dstUnzipDir, String newPrefix) {
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);
            zipFile.setFileNameCharset("UTF-8");
            if (!StringUtils.isEmpty(newPrefix)) {
                for (Object zipFileHeader : zipFile.getFileHeaders()) {
                    FileHeader fileHeader = (FileHeader) zipFileHeader;
                    fileHeader.setFileName(newPrefix + fileHeader.getFileName());
                }
            }
            zipFile.extractAll(dstUnzipDir);
        } catch (ZipException e) {
            LOG.error("ZipUtil.unzipAllFiles err, source:{}, dst:{}", zipFilePath, dstUnzipDir, e);
        }
    }

    public static void main(String[] args) {
        String zipPath = "/Users/xiaohu/Downloads/test/S218_张三2017健康体检.xlsx.zip";
        String dstDir = "/Users/xiaohu/Downloads/test";
        unzipAllFilesAndAddPrefix(zipPath, dstDir, "2019");
    }

}
