package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.FreightPlanDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.FreightPlanDBQuery;
import com.xingyi.logistic.business.db.entity.FreightPlanDO;
import com.xingyi.logistic.business.model.FreightPlan;
import com.xingyi.logistic.business.model.FreightPlanQuery;
import com.xingyi.logistic.business.service.FreightPlanService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.FreightPlanConverter;
import com.xingyi.logistic.business.service.converter.FreightPlanQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FreightPlanServiceImpl extends BaseCRUDService<FreightPlanDO, FreightPlan, FreightPlanDBQuery, FreightPlanQuery> implements FreightPlanService {

    @Autowired
    private FreightPlanDAO freightPlanDAO;

    @Autowired
    private FreightPlanConverter freightPlanConverter;

    @Autowired
    private FreightPlanQueryConverter freightPlanQueryConverter;



    @Override
    protected ModelConverter<FreightPlanDO, FreightPlan> getModelConverter() {
        return freightPlanConverter;
    }

    @Override
    protected BaseDAO<FreightPlanDO, FreightPlanDBQuery> getDAO() {
        return freightPlanDAO;
    }

    @Override
    protected QueryConditionConverter<FreightPlanQuery, FreightPlanDBQuery> getConditionConverter() {
        return freightPlanQueryConverter;
    }
}
