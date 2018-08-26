package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.Customer;
import com.xingyi.logistic.business.model.CustomerQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户信息
 */
@Biz("客户信息")
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseCRUDController<Customer, CustomerQuery> {

    @Autowired
    private CustomerService customerService;

    @Override
    protected BaseService<Customer, CustomerQuery> getBaseService() {
        return customerService;
    }
}
