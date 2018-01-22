package com.xingyi.logistic.authentication.service.impl;

import com.xingyi.logistic.authentication.db.dao.DataDictionaryDAO;
import com.xingyi.logistic.authentication.db.entity.DataDictionaryDBQuery;
import com.xingyi.logistic.authentication.db.entity.DataDictionaryDO;
import com.xingyi.logistic.authentication.model.DataDictionary;
import com.xingyi.logistic.authentication.model.DataDictionaryQuery;
import com.xingyi.logistic.authentication.service.DataDictionaryService;
import com.xingyi.logistic.authentication.service.converter.DataDictionaryConverter;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.DataDictionaryQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataDictionaryServiceImpl extends BaseCRUDService<DataDictionaryDO,DataDictionary,DataDictionaryDBQuery,DataDictionaryQuery> implements DataDictionaryService {

    @Autowired
    private DataDictionaryDAO dataDictionaryDAO;

    @Autowired
    private DataDictionaryConverter dataDictionaryConverter;

    @Autowired
    private DataDictionaryQueryConverter dataDictionaryQueryConverter;

    @Override
    protected ModelConverter<DataDictionaryDO, DataDictionary> getModelConverter() {
        return this.dataDictionaryConverter;
    }

    @Override
    protected BaseDAO<DataDictionaryDO, DataDictionaryDBQuery> getDAO() {
        return this.dataDictionaryDAO;
    }

    @Override
    protected QueryConditionConverter<DataDictionaryQuery, DataDictionaryDBQuery> getConditionConverter() {
        return this.dataDictionaryQueryConverter;
    }
}
