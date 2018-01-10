package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.ContractFlow;
import com.xingyi.logistic.business.model.ContractFlowQuery;
import com.xingyi.logistic.business.model.Customer;
import com.xingyi.logistic.business.model.CustomerQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ContractFlowService;
import com.xingyi.logistic.business.service.CustomerService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户信息
 */
@RestController
@RequestMapping("/contractFlow")
public class ContractFlowController extends BaseCRUDController<ContractFlow, ContractFlowQuery> {

    @Autowired
    private ContractFlowService contractFlowService;

    @Override
    public JsonRet<Long> add(ContractFlow contractFlow) {
        return super.add(contractFlow);
    }
    @Override
    public JsonRet<Boolean> modify(ContractFlow contractFlow) {
        return super.modify(contractFlow);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<ContractFlow> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(ContractFlowQuery contractFlowQuery) {
        return super.getList(contractFlowQuery);
    }

    @Override
    protected BaseService<ContractFlow, ContractFlowQuery> getBaseService() {
        return contractFlowService;
    }
}
