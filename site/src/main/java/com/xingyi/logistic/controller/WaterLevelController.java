package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.WaterLevel;
import com.xingyi.logistic.business.model.WaterLevelQuery;
import com.xingyi.logistic.business.service.WaterLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xingyi.logistic.business.service.BaseService;

@RestController
@RequestMapping("/waterLevel")
public class WaterLevelController extends BaseCRUDController<WaterLevel,WaterLevelQuery>{

    @Autowired
    private WaterLevelService waterLevelService;

    @Override
    protected BaseService<WaterLevel, WaterLevelQuery> getBaseService() {
        return waterLevelService;
    }
}
