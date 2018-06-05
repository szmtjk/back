package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ShippingPlanDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShippingPlanDBQuery;
import com.xingyi.logistic.business.db.entity.ShippingPlanDO;
import com.xingyi.logistic.business.model.ShippingPlan;
import com.xingyi.logistic.business.model.ShippingPlanQuery;
import com.xingyi.logistic.business.service.ShippingPlanService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShippingPlanConverter;
import com.xingyi.logistic.business.service.converter.ShippingPlanQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShippingPlanServiceImpl extends BaseCRUDService<ShippingPlanDO, ShippingPlan, ShippingPlanDBQuery, ShippingPlanQuery> implements ShippingPlanService {

    @Autowired
    private ShippingPlanDAO shippingPlanDAO;

    @Autowired
    private ShippingPlanConverter shippingPlanConverter;

    @Autowired
    private ShippingPlanQueryConverter shippingPlanQueryConverter;



    @Override
    protected ModelConverter<ShippingPlanDO, ShippingPlan> getModelConverter() {
        return shippingPlanConverter;
    }

    @Override
    protected BaseDAO<ShippingPlanDO, ShippingPlanDBQuery> getDAO() {
        return shippingPlanDAO;
    }

    @Override
    protected QueryConditionConverter<ShippingPlanQuery, ShippingPlanDBQuery> getConditionConverter() {
        return shippingPlanQueryConverter;
    }
}
