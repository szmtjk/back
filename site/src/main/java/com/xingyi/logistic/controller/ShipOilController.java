package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.ShipOil;
import com.xingyi.logistic.business.model.ShipOilQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShipOilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 船舶加油管理
 */
@Biz("船舶加油管理")
@RestController
@RequestMapping("/shipOil")
public class ShipOilController extends BaseCRUDController<ShipOil, ShipOilQuery> {

    @Autowired
    private ShipOilService shipOilService;

    @Override
    protected BaseService<ShipOil, ShipOilQuery> getBaseService() {
        return shipOilService;
    }



}
