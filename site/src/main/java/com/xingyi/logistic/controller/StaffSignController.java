package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.StaffSign;
import com.xingyi.logistic.business.model.StaffSignQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.StaffSignService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工签到管理
 */
@Biz("员工签到管理")
@RestController
@RequestMapping("/staffSign")
public class StaffSignController extends BaseCRUDController<StaffSign, StaffSignQuery> {

    @Autowired
    private StaffSignService StaffSignService;

    @RequestMapping(value = "/getPage", method = {RequestMethod.GET,RequestMethod.POST})
    public JsonRet<Object> getPage(@JsonParam StaffSignQuery staffSignQuery) {
        if("".equals(staffSignQuery.getKey())){
            staffSignQuery.setKey(null);
        }
        return super.getList(staffSignQuery);
    }

    @Override
    protected BaseService<StaffSign, StaffSignQuery> getBaseService() {
        return StaffSignService;
    }



}
