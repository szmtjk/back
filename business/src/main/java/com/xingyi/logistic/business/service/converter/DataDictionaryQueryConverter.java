package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.authentication.db.entity.DataDictionaryDBQuery;
import com.xingyi.logistic.authentication.model.DataDictionaryQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
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
