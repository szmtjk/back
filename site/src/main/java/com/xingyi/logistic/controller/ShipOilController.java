package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.ShipOil;
import com.xingyi.logistic.business.model.ShipOilQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShipOilService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 船舶加油管理
 */
@RestController
@RequestMapping("/shipOil")
public class ShipOilController extends BaseCRUDController<ShipOil, ShipOilQuery> {

    @Autowired
    private ShipOilService shipOilService;

    @Override
    public JsonRet<Long> add(ShipOil shipOil) {
        return super.add(shipOil);
    }
    @Override
    public JsonRet<Boolean> modify(ShipOil shipOil) {
        return super.modify(shipOil);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<ShipOil> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(ShipOilQuery shipOilQuery) {
        return super.getList(shipOilQuery);
    }

    @Override
    protected BaseService<ShipOil, ShipOilQuery> getBaseService() {
        return shipOilService;
    }



}
