package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.model.ShipStaff;
import com.xingyi.logistic.business.model.ShipStaffQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.ShipStaffService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jadic on 2017/12/31.
 */
@RestController
@RequestMapping("/shipStaff")
public class ShipStaffController extends BaseCRUDController<ShipStaff, ShipStaffQuery> {

    @Autowired
    private ShipStaffService shipStaffService;

    @Override
    public JsonRet<Long> add(ShipStaff shipStaff) {
        return super.add(shipStaff);
    }
    @Override
    public JsonRet<Boolean> modify(ShipStaff shipStaff) {
        return super.modify(shipStaff);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<ShipStaff> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(ShipStaffQuery shipStaffQuery) {
        return super.getList(shipStaffQuery);
    }

    @Override
    protected BaseService<ShipStaff, ShipStaffQuery> getBaseService() {
        return shipStaffService;
    }

    @RequestMapping(value = "/judege", method = RequestMethod.POST)
    public JsonRet<Integer> judege(ShipStaff shipStaff) {
        return shipStaffService.judege(shipStaff);
    }
}
