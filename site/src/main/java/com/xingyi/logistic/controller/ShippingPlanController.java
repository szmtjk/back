package com.xingyi.logistic.controller;


import com.xingyi.logistic.business.model.ShippingPlan;
import com.xingyi.logistic.business.model.ShippingPlanQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShippingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 船运计划管理
 */
@RestController
@RequestMapping("/shippingPlan")
public class ShippingPlanController extends BaseCRUDController<ShippingPlan,ShippingPlanQuery> {

    @Autowired
    private ShippingPlanService shippingPlanService;


    @Override
    protected BaseService<ShippingPlan, ShippingPlanQuery> getBaseService() {
        return shippingPlanService;
    }
}
