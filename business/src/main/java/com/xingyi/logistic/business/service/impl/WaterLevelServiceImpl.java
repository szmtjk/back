package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.WaterLevelDAO;
import com.xingyi.logistic.business.db.entity.WaterLevelDBQuery;
import com.xingyi.logistic.business.db.entity.WaterLevelDO;
import com.xingyi.logistic.business.model.WaterLevel;
import com.xingyi.logistic.business.model.WaterLevelQuery;
import com.xingyi.logistic.business.service.WaterLevelService;
import com.xingyi.logistic.business.service.converter.WaterLevelConverter;
import com.xingyi.logistic.business.service.converter.WaterLevelQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.base.BaseCRUDService;

@Service
public class WaterLevelServiceImpl extends BaseCRUDService<WaterLevelDO,WaterLevel,WaterLevelDBQuery,WaterLevelQuery> implements WaterLevelService {

    @Autowired
    private WaterLevelDAO waterLevelDAO;

    @Autowired
    private WaterLevelConverter waterLevelConverter;

    @Autowired
    private WaterLevelQueryConverter waterLevelQueryConverter;

    @Override
    protected ModelConverter<WaterLevelDO, WaterLevel> getModelConverter() {
        return waterLevelConverter;
    }

    @Override
    protected BaseDAO<WaterLevelDO, WaterLevelDBQuery> getDAO() {
        return waterLevelDAO;
    }

    @Override
    protected QueryConditionConverter<WaterLevelQuery, WaterLevelDBQuery> getConditionConverter() {
        return waterLevelQueryConverter;
    }
}
