package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.Customer;
import com.xingyi.logistic.business.model.CustomerQuery;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.CustomerService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户信息
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseCRUDController<Customer, CustomerQuery> {

    @Autowired
    private CustomerService customerService;

    @Override
    public JsonRet<Long> add(Customer customer) {
        return super.add(customer);
    }
    @Override
    public JsonRet<Boolean> modify(Customer customer) {
        return super.modify(customer);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<Customer> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(CustomerQuery customerQuery) {
        return super.getList(customerQuery);
    }

    @Override
    protected BaseService<Customer, CustomerQuery> getBaseService() {
        return customerService;
    }
}
