package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.DangerZone;
import com.xingyi.logistic.business.model.DangerZoneQuery;
import com.xingyi.logistic.business.model.WaterLevel;
import com.xingyi.logistic.business.model.WaterLevelQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.DangerZoneService;
import com.xingyi.logistic.business.service.WaterLevelService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 危险区域
 */
@RestController
@RequestMapping("/waterLevel")
public class WaterLevelController extends BaseCRUDController<WaterLevel, WaterLevelQuery> {

    @Autowired
    private WaterLevelService waterLevelService;

    @Override
    public JsonRet<Long> add(WaterLevel waterLevel) {
        return super.add(waterLevel);
    }
    @Override
    public JsonRet<Boolean> modify(WaterLevel waterLevel) {
        return super.modify(waterLevel);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<WaterLevel> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(WaterLevelQuery waterLevelQuery) {
        return super.getList(waterLevelQuery);
    }

    @Override
    protected BaseService<WaterLevel, WaterLevelQuery> getBaseService() {
        return waterLevelService;
    }
}
