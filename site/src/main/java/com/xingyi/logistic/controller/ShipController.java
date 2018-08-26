package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.aop.annotation.Operation;
import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 船舶
 */
@Biz("船舶信息")
@RestController
@RequestMapping("/ship")
public class ShipController extends BaseCRUDController<Ship, ShipQuery> {

    @Autowired
    private ShipService shipService;

    @Operation("app端修改")
    @RequestMapping(value = "/appModify", method = RequestMethod.POST)
    public JsonRet<Boolean> appModify(Ship ship) {
        AppUser mAppUser = SessionUtil.getAppUser();
        if (mAppUser != null)
        {
            ship.setId(mAppUser.getShipInfoId());
            return super.modify(ship);
        }
        else
        {
            JsonRet<Boolean> ret = new JsonRet<>();
            ret.setSuccess(false);
            return ret;
        }
    }

    @Override
    protected BaseService<Ship, ShipQuery> getBaseService() {
        return shipService;
    }


    /**
     * APP端加载
     * @return
     */
    @RequestMapping(value = "/getAppById", method = RequestMethod.GET)
    public JsonRet<Object> getAppById()
    {
        return shipService.getAppById(SessionUtil.getAppUser());
    }


    /**
     * 通过token获取船舶id和船号
     * @return
     */
    @RequestMapping(value = "/getShipInfo", method = {RequestMethod.GET,RequestMethod.POST})
    public JsonRet<Object> getShipInfo() {
        UserProfile profile = SessionUtil.getProfile();
        return shipService.getShipInfo(profile);
    }
}
