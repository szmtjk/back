package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.Contract;
import com.xingyi.logistic.business.model.ContractQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ContractService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 合同信息
 */
@RestController
@RequestMapping("/contract")
public class ContractController extends BaseCRUDController<Contract, ContractQuery> {

    @Autowired
    private ContractService contractService;

    @Override
    public JsonRet<Long> add(Contract contract) {
        return super.add(contract);
    }

    @Override
    public JsonRet<Boolean> modify(Contract contract) {
        return super.modify(contract);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<Contract> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(ContractQuery contractQuery) {
        return super.getList(contractQuery);
    }

    @Override
    protected BaseService<Contract, ContractQuery> getBaseService() {
        return contractService;
    }
}
