package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 船舶
 */
@RestController
@RequestMapping("/ship")
public class ShipController extends BaseCRUDController<Ship, ShipQuery> {

    @Autowired
    private ShipService shipService;


    @Override
    public JsonRet<Long> add(Ship ship) {
        return super.add(ship);
    }
    @Override
    public JsonRet<Boolean> modify(Ship ship) {
        return super.modify(ship);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<Ship> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(ShipQuery shipQuery) {
        return super.getList(shipQuery);
    }

    @Override
    protected BaseService<Ship, ShipQuery> getBaseService() {
        return shipService;
    }
}
