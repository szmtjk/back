package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.DangerZoneSpeed;
import com.xingyi.logistic.business.model.DangerZoneSpeedQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.DangerZoneSpeedService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 危险区域
 */
@Biz("危险区域速度")
@RestController
@RequestMapping("/dangerZoneSpeed")
public class DangerZoneSpeedController extends BaseCRUDController<DangerZoneSpeed, DangerZoneSpeedQuery> {

    @Autowired
    private DangerZoneSpeedService dangerZoneSpeedService;

    @Override
    protected BaseService<DangerZoneSpeed, DangerZoneSpeedQuery> getBaseService() {
        return dangerZoneSpeedService;
    }

    @RequestMapping(value = "/getPage", method = RequestMethod.POST)
    public JsonRet<Object> getPage(@JsonParam DangerZoneSpeedQuery dangerZoneSpeedQuery) {
        return super.getList(dangerZoneSpeedQuery);
    }
}
