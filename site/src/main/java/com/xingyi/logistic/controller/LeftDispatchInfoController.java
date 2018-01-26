package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.LeftDispatchInfo;
import com.xingyi.logistic.business.model.LeftDispatchInfoQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.LeftDispatchInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 余量临调信息
 */
@RestController
@RequestMapping("/leftDispatchInfo")
public class LeftDispatchInfoController extends BaseCRUDController<LeftDispatchInfo,LeftDispatchInfoQuery>{

    @Autowired
    private LeftDispatchInfoService leftDispatchInfoService;

    @Override
    protected BaseService<LeftDispatchInfo, LeftDispatchInfoQuery> getBaseService() {
        return leftDispatchInfoService;
    }
}
