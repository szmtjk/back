package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.PlanRefuelingDAO;
import com.xingyi.logistic.business.db.dao.PreBuckleOilDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PlanRefuelingDBQuery;
import com.xingyi.logistic.business.db.entity.PlanRefuelingDO;
import com.xingyi.logistic.business.db.entity.PreBuckleOilDBQuery;
import com.xingyi.logistic.business.db.entity.PreBuckleOilDO;
import com.xingyi.logistic.business.model.PlanRefueling;
import com.xingyi.logistic.business.model.PlanRefuelingQuery;
import com.xingyi.logistic.business.model.PreBuckleOil;
import com.xingyi.logistic.business.model.PreBuckleOilQuery;
import com.xingyi.logistic.business.service.PlanRefuelingService;
import com.xingyi.logistic.business.service.PreBuckleOilService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.PlanRefuelingConverter;
import com.xingyi.logistic.business.service.converter.PlanRefuelingQueryConverter;
import com.xingyi.logistic.business.service.converter.PreBuckleOilConverter;
import com.xingyi.logistic.business.service.converter.PreBuckleOilQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * wzf
 */
@Service
public class PlanRefuelingServiceImpl extends BaseCRUDService<PlanRefuelingDO, PlanRefueling, PlanRefuelingDBQuery, PlanRefuelingQuery> implements PlanRefuelingService {

    @Autowired
    private PlanRefuelingDAO planRefuelingDAO;

    @Autowired
    private PlanRefuelingConverter planRefuelingConverter;

    @Autowired
    private PlanRefuelingQueryConverter planRefuelingQueryConverter;

    @Override
    protected ModelConverter<PlanRefuelingDO, PlanRefueling> getModelConverter() {
        return planRefuelingConverter;
    }

    @Override
    protected BaseDAO<PlanRefuelingDO, PlanRefuelingDBQuery> getDAO() {
        return planRefuelingDAO;
    }

    @Override
    protected QueryConditionConverter<PlanRefuelingQuery, PlanRefuelingDBQuery> getConditionConverter() {
        return planRefuelingQueryConverter;
    }
}
