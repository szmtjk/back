package com.szmtjk.business.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZipUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ZipUtil.class);

    private static final Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");;

    public static void unzipAllFiles(String zipFilePath, String dstUnzipDir) {
        unzipAllFilesAndAddPrefix(zipFilePath, dstUnzipDir, null);
    }

    public static void unzipAllFilesAndAddPrefix(String zipFilePath, String dstUnzipDir, String newPrefix) {
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);
            zipFile.setFileNameCharset(getEncoding(zipFilePath));
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

    private static String getEncoding(String path) {
        String encoding = "GBK";
        try {
            ZipFile zipFile  = new ZipFile(path);
            zipFile.setFileNameCharset(encoding);
            List<FileHeader> list = zipFile.getFileHeaders();
            for (FileHeader fileHeader : list) {
                if (isMessyCode(fileHeader.getFileName())) {
                    encoding = "UTF-8";
                    break;
                }
            }
        } catch (ZipException e) {
            LOG.error("ZipUtil.getEncoding err, path", path, e);
        }
        return encoding;
    }

    private static boolean isMessyCode(String str) {
        Matcher m = p.matcher(str);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();

        int length = (ch != null) ? ch.length : 0;
        for (int i = 0; i < length; i++) {
            char c = ch[i];
            if (!Character.isLetterOrDigit(c)) {
                String ss = "" + ch[i];
                if (!ss.matches("[\u4e00-\u9fa5]+")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String zipPath = "/Users/xiaohu/Downloads/test/S218_张三2017健康体检.xlsx.zip";
        String dstDir = "/Users/xiaohu/Downloads/test";
        unzipAllFilesAndAddPrefix(zipPath, dstDir, "2019");
    }

}
