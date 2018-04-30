package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.WaterLevel;
import com.xingyi.logistic.business.model.WaterLevelQuery;
import com.xingyi.logistic.business.service.WaterLevelService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.xingyi.logistic.business.service.BaseService;

@RestController
@RequestMapping("/waterLevel")
public class WaterLevelController extends BaseCRUDController<WaterLevel,WaterLevelQuery>{

    @Autowired
    private WaterLevelService waterLevelService;

    @RequestMapping(value = "/getPage", method = RequestMethod.POST)
    public JsonRet<Object> getPage(@JsonParam WaterLevelQuery waterLevelQuery) {
        return super.getList(waterLevelQuery);
    }

    @Override
    protected BaseService<WaterLevel, WaterLevelQuery> getBaseService() {
        return waterLevelService;
    }
}
