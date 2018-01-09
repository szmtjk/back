package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.DangerZoneSpeed;
import com.xingyi.logistic.business.model.DangerZoneSpeedQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.DangerZoneSpeedService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 危险区域
 */
@RestController
@RequestMapping("/dangerZoneSpeed")
public class DangerZoneSpeedController extends BaseCRUDController<DangerZoneSpeed, DangerZoneSpeedQuery> {

    @Autowired
    private DangerZoneSpeedService dangerZoneSpeedService;

    @Override
    public JsonRet<Long> add(DangerZoneSpeed dangerZoneSpeed) {
        return super.add(dangerZoneSpeed);
    }
    @Override
    public JsonRet<Boolean> modify(DangerZoneSpeed dangerZoneSpeed) {
        return super.modify(dangerZoneSpeed);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<DangerZoneSpeed> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(DangerZoneSpeedQuery dangerZoneSpeedQuery) {
        return super.getList(dangerZoneSpeedQuery);
    }

    @Override
    protected BaseService<DangerZoneSpeed, DangerZoneSpeedQuery> getBaseService() {
        return dangerZoneSpeedService;
    }
}
