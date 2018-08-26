package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.Combox;
import com.xingyi.logistic.business.model.CustomerTaskFlow;
import com.xingyi.logistic.business.model.CustomerTaskFlowQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.CustomerTaskFlowService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 客户任务流向
 */
@Biz("客户任务流向")
@RestController
@RequestMapping("/customerTaskFlow")
public class CustomerTaskFlowController extends BaseCRUDController<CustomerTaskFlow, CustomerTaskFlowQuery> {

    @Autowired
    private CustomerTaskFlowService customerTaskFlowService;

    @RequestMapping(value = "/loadWeight", method = RequestMethod.POST)
    public JsonRet<Long> loadWeight(@RequestParam Map<String, String> map) {
        return customerTaskFlowService.queryTotalWeightInfo(map);
    }


    /**
     * 从运价管理中取（客户、合同、流向、时间）
     *
     * @param map
     * @return
     */
    @RequestMapping(value = "/loadUnitPrice", method = RequestMethod.POST)
    public List<Combox> loadUnitPrice(@RequestParam Map<String, String> map) {
        return customerTaskFlowService.queryUnitPriceInfo(map);
    }

    @Override
    protected BaseService<CustomerTaskFlow, CustomerTaskFlowQuery> getBaseService() {
        return customerTaskFlowService;
    }
}
