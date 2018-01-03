package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.Port;
import com.xingyi.logistic.business.model.PortQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.PortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jadic on 2017/12/31.
 */
@RestController
@RequestMapping("/port")
public class PortController extends BaseCRUDController<Port, PortQuery> {

    @Autowired
    private PortService portService;

    @Override
    protected BaseService<Port, PortQuery> getBaseService() {
        return portService;
    }
}
