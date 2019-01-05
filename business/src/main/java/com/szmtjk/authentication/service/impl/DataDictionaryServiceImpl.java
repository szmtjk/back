package com.szmtjk.authentication.service.impl;

import com.szmtjk.authentication.service.converter.DataDictionaryConverter;
import com.szmtjk.authentication.db.dao.DataDictionaryDAO;
import com.szmtjk.authentication.db.entity.DataDictionaryDBQuery;
import com.szmtjk.authentication.db.entity.DataDictionaryDO;
import com.szmtjk.authentication.model.DataDictionary;
import com.szmtjk.authentication.model.DataDictionaryQuery;
import com.szmtjk.authentication.service.DataDictionaryService;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.service.base.ModelConverter;
import com.szmtjk.business.service.base.QueryConditionConverter;
import com.szmtjk.business.service.converter.DataDictionaryQueryConverter;
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
