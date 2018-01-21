package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.*;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.CustomerTaskService;
import com.xingyi.logistic.business.service.PortService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户任务
 */
@RestController
@RequestMapping("/customerTask")
public class CustomerTaskController extends BaseCRUDController<CustomerTask, CustomerTaskQuery> {

    @Autowired
    private CustomerTaskService customerTaskService;

    @Override
    protected BaseService<CustomerTask, CustomerTaskQuery> getBaseService() {
        return customerTaskService;
    }

    /**
     * 加载合同
     * @return
     */
    @RequestMapping("/loadCustomer")
    public List<Combox> loadCustomer()
    {
        return customerTaskService.queryComboxCustomerInfo();
    }

    /**
     * 合同id加载客户名称
     * @return
     */
    @RequestMapping("/loadContractById")
    public List<Combox> loadContractById(@JsonParam CustomerTaskQuery customerTaskQuery) {

        return customerTaskService.loadContractById(customerTaskQuery);
    }

    /**
     * 合同id加载合同流向
     * @return
     */
    @RequestMapping("/loadContractFlowByContractId")
    public List<Combox> loadContractFlowByContractId(@JsonParam CustomerTaskQuery customerTaskQuery) {

        return customerTaskService.loadContractFlowByContractId(customerTaskQuery);
    }
}
