package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.PreBuckleOilDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PreBuckleOilDBQuery;
import com.xingyi.logistic.business.db.entity.PreBuckleOilDO;
import com.xingyi.logistic.business.model.PreBuckleOil;
import com.xingyi.logistic.business.model.PreBuckleOilQuery;
import com.xingyi.logistic.business.service.PreBuckleOilService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.PreBuckleOilConverter;
import com.xingyi.logistic.business.service.converter.PreBuckleOilQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * wzf
 */
@Service
public class PreBuckleOilServiceImpl extends BaseCRUDService<PreBuckleOilDO, PreBuckleOil, PreBuckleOilDBQuery, PreBuckleOilQuery> implements PreBuckleOilService {

    @Autowired
    private PreBuckleOilDAO preBuckleOilDAO;

    @Autowired
    private PreBuckleOilConverter preBuckleOilConverter;

    @Autowired
    private PreBuckleOilQueryConverter preBuckleOilQueryConverter;

    @Override
    protected ModelConverter<PreBuckleOilDO, PreBuckleOil> getModelConverter() {
        return preBuckleOilConverter;
    }

    @Override
    protected BaseDAO<PreBuckleOilDO, PreBuckleOilDBQuery> getDAO() {
        return preBuckleOilDAO;
    }

    @Override
    protected QueryConditionConverter<PreBuckleOilQuery, PreBuckleOilDBQuery> getConditionConverter() {
        return preBuckleOilQueryConverter;
    }
}
