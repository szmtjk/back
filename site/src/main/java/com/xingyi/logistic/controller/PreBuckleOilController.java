package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.Port;
import com.xingyi.logistic.business.model.PortQuery;
import com.xingyi.logistic.business.model.PreBuckleOil;
import com.xingyi.logistic.business.model.PreBuckleOilQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.PortService;
import com.xingyi.logistic.business.service.PreBuckleOilService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * wzf
 */
@RestController
@RequestMapping("/preBuckleOil")
public class PreBuckleOilController extends BaseCRUDController<PreBuckleOil, PreBuckleOilQuery> {

    @Autowired
    private PreBuckleOilService preBuckleOilService;

    @Override
    protected BaseService<PreBuckleOil, PreBuckleOilQuery> getBaseService() {
        return preBuckleOilService;
    }
}
