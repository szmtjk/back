package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.CustomerTaskFlow;
import com.xingyi.logistic.business.model.CustomerTaskFlowQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.CustomerTaskFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户任务流向
 */
@RestController
@RequestMapping("/customerTaskFlow")
public class CustomerTaskFlowController extends BaseCRUDController<CustomerTaskFlow, CustomerTaskFlowQuery> {

    @Autowired
    private CustomerTaskFlowService customerTaskFlowService;

    @Override
    protected BaseService<CustomerTaskFlow, CustomerTaskFlowQuery> getBaseService() {
        return customerTaskFlowService;
    }
}
