package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.Contract;
import com.xingyi.logistic.business.model.ContractQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 合同信息
 */
@Biz("合同信息")
@RestController
@RequestMapping("/contract")
public class ContractController extends BaseCRUDController<Contract, ContractQuery> {

    @Autowired
    private ContractService contractService;

    @Override
    protected BaseService<Contract, ContractQuery> getBaseService() {
        return contractService;
    }
}
