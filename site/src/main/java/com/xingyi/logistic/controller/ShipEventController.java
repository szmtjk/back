package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.ShipEvent;
import com.xingyi.logistic.business.model.ShipEventQuery;
import com.xingyi.logistic.business.model.WaterLevel;
import com.xingyi.logistic.business.model.WaterLevelQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShipEventService;
import com.xingyi.logistic.business.service.WaterLevelService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipEvent")
public class ShipEventController extends BaseCRUDController<ShipEvent,ShipEventQuery>{

    @Autowired
    private ShipEventService shipEventService;

    @Override
    protected BaseService<ShipEvent, ShipEventQuery> getBaseService() {
        return shipEventService;
    }
}
