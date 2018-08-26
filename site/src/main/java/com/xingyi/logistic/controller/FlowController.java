package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.Flow;
import com.xingyi.logistic.business.model.FlowQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流向信息
 */
@Biz("流向信息")
@RestController
@RequestMapping("/flow")
public class FlowController extends BaseCRUDController<Flow, FlowQuery> {

    @Autowired
    private FlowService flowService;

    @Override
    protected BaseService<Flow, FlowQuery> getBaseService() {
        return flowService;
    }
}
