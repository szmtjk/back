package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.SailingInfo;
import com.xingyi.logistic.business.model.SailingInfoQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.SailingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 航次信息
 */
@RestController
@RequestMapping("/sailingInfo")
public class SailingInfoController extends BaseCRUDController<SailingInfo, SailingInfoQuery> {

    @Autowired
    private SailingInfoService sailingInfoService;

    @Override
    protected BaseService<SailingInfo,SailingInfoQuery> getBaseService() {
        return sailingInfoService;
    }
}
