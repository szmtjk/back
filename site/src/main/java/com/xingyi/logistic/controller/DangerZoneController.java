package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.Customer;
import com.xingyi.logistic.business.model.CustomerQuery;
import com.xingyi.logistic.business.model.DangerZone;
import com.xingyi.logistic.business.model.DangerZoneQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.CustomerService;
import com.xingyi.logistic.business.service.DangerZoneService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 危险区域
 */
@RestController
@RequestMapping("/dangerZone")
public class DangerZoneController extends BaseCRUDController<DangerZone, DangerZoneQuery> {

    @Autowired
    private DangerZoneService dangerZoneService;

    @Override
    public JsonRet<Long> add(DangerZone dangerZone) {
        return super.add(dangerZone);
    }
    @Override
    public JsonRet<Boolean> modify(DangerZone dangerZone) {
        return super.modify(dangerZone);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<DangerZone> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(DangerZoneQuery dangerZoneQuery) {
        return super.getList(dangerZoneQuery);
    }

    @Override
    protected BaseService<DangerZone, DangerZoneQuery> getBaseService() {
        return dangerZoneService;
    }
}
