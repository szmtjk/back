package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.StaffSign;
import com.xingyi.logistic.business.model.StaffSignQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.StaffSignService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工签到管理
 */
@RestController
@RequestMapping("/staffSign")
public class StaffSignController extends BaseCRUDController<StaffSign, StaffSignQuery> {

    @Autowired
    private StaffSignService StaffSignService;

    @Override
    public JsonRet<Long> add(StaffSign StaffSign) {
        return super.add(StaffSign);
    }
    @Override
    public JsonRet<Boolean> modify(StaffSign StaffSign) {
        return super.modify(StaffSign);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<StaffSign> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(StaffSignQuery StaffSignQuery) {
        return super.getList(StaffSignQuery);
    }

    @Override
    protected BaseService<StaffSign, StaffSignQuery> getBaseService() {
        return StaffSignService;
    }



}
