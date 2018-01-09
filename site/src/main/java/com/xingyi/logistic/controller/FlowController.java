package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.Flow;
import com.xingyi.logistic.business.model.FlowQuery;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.FlowService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流向信息
 */
@RestController
@RequestMapping("/flow")
public class FlowController extends BaseCRUDController<Flow, FlowQuery> {

    @Autowired
    private FlowService flowService;

    @Override
    public JsonRet<Long> add(Flow flow) {
        return super.add(flow);
    }
    @Override
    public JsonRet<Boolean> modify(Flow flow) {
        return super.modify(flow);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<Flow> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(FlowQuery flowQuery) {
        return super.getList(flowQuery);
    }

    @Override
    protected BaseService<Flow, FlowQuery> getBaseService() {
        return flowService;
    }
}
