package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.TempDispatchShip;
import com.xingyi.logistic.business.model.TempDispatchShipQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.TempDispatchShipService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 临调船舶
 */
@RestController
@RequestMapping("/tempDispatchShip")
public class TempDispatchShipController extends BaseCRUDController<TempDispatchShip, TempDispatchShipQuery> {

    @Autowired
    private TempDispatchShipService tempDispatchService;


    @Override
    public JsonRet<Long> add(TempDispatchShip tempDispatchShip) {
        return super.add(tempDispatchShip);
    }
    @Override
    public JsonRet<Boolean> modify(TempDispatchShip tempDispatchShip) {
        return super.modify(tempDispatchShip);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<TempDispatchShip> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(TempDispatchShipQuery tempDispatchShipQuery) {
        return super.getList(tempDispatchShipQuery);
    }

    @Override
    protected BaseService<TempDispatchShip, TempDispatchShipQuery> getBaseService() {
        return tempDispatchService;
    }
}
