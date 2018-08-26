package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.ContractFlow;
import com.xingyi.logistic.business.model.ContractFlowQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ContractFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户信息
 */
@Biz("合同流向信息")
@RestController
@RequestMapping("/contractFlow")
public class ContractFlowController extends BaseCRUDController<ContractFlow, ContractFlowQuery> {

    @Autowired
    private ContractFlowService contractFlowService;

    @Override
    protected BaseService<ContractFlow, ContractFlowQuery> getBaseService() {
        return contractFlowService;
    }
}
