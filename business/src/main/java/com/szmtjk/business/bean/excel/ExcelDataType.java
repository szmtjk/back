package com.szmtjk.business.bean.excel;

/**
 * Excel数据类型
 */
public enum ExcelDataType {

    /**
     * 简单的，一行标题，后续每行都是一条数据
     */
    SIMPLE,

    /**
     * 复杂结构的，规则自定义，需解析多行才能拼装一条记录的
     */
    COMPLICATED
}
