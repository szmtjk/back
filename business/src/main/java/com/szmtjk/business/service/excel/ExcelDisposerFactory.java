package com.szmtjk.business.service.excel;

import com.szmtjk.business.service.BizExcelDisposer;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExcelDisposerFactory {

    private static final Map<String, BizExcelDisposer> disposerMap = new ConcurrentHashMap<>();

    public static void addDisposer(BizExcelDisposer disposer) {
        disposerMap.put(disposer.getDisposerKey(), disposer);
    }

    public static BizExcelDisposer getExcelDisposer(String disposerKey) {
        return disposerMap.get(disposerKey);
    }
}
