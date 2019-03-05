package com.szmtjk.business.converter;

import com.szmtjk.business.converter.base.QueryConditionConverter;
import com.szmtjk.business.db.entity.FileImportStatusDBQuery;
import com.szmtjk.business.model.FileImportStatusQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * auto generated by code helper on 2019-03-04.
 */
@Component
public class FileImportStatusQueryConverter extends QueryConditionConverter<FileImportStatusQuery, FileImportStatusDBQuery> {

    @Override
    public FileImportStatusDBQuery toDOCondition(FileImportStatusQuery src) {
        FileImportStatusDBQuery dst = new FileImportStatusDBQuery();
        if (src != null) {
            paginationConvert(src, dst);
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

}