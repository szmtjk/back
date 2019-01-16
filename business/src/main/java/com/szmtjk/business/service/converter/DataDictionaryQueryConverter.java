package com.szmtjk.business.service.converter;

import com.szmtjk.authentication.db.entity.DataDictionaryDBQuery;
import com.szmtjk.authentication.model.DataDictionaryQuery;
import com.szmtjk.business.converter.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DataDictionaryQueryConverter extends QueryConditionConverter<DataDictionaryQuery,DataDictionaryDBQuery> {
    @Override
    public DataDictionaryDBQuery toDOCondition(DataDictionaryQuery dataDictionaryQuery) {
        DataDictionaryDBQuery dst = new DataDictionaryDBQuery();
        if (dataDictionaryQuery != null) {
            paginationConvert(dataDictionaryQuery, dst);
            BeanUtils.copyProperties(dataDictionaryQuery, dst);
        }
        return dst;
    }
}
