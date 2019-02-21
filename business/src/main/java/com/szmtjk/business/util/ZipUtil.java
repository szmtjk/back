package com.szmtjk.business.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZipUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ZipUtil.class);

    public static void unzipAllFiles(String zipFilePath, String dstUnzipDir) {
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);
            zipFile.extractAll(dstUnzipDir);
        } catch (ZipException e) {
            LOG.error("ZipUtil.unzipAllFiles err, source:{}, dst:{}", zipFilePath, dstUnzipDir);
        }
    }
}
