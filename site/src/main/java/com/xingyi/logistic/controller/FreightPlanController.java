package com.xingyi.logistic.controller;


import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.FreightPlan;
import com.xingyi.logistic.business.model.FreightPlanQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.FreightPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 货运计划管理
 */
@Biz("货运计划管理")
@RestController
@RequestMapping("/freightPlan")
public class FreightPlanController extends BaseCRUDController<FreightPlan,FreightPlanQuery> {

    @Autowired
    private FreightPlanService freightPlanService;


    @Override
    protected BaseService<FreightPlan, FreightPlanQuery> getBaseService() {
        return freightPlanService;
    }
}
