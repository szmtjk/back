package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.aop.annotation.Operation;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.model.TempDispatchShip;
import com.xingyi.logistic.business.model.TempDispatchShipQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.TempDispatchShipService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import com.xingyi.logistic.qiangdan.model.AppUser;
import com.xingyi.logistic.qiangdan.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 临调船舶
 */
@Biz("临调船舶")
@RestController
@RequestMapping("/tempDispatchShip")
public class TempDispatchShipController extends BaseCRUDController<TempDispatchShip, TempDispatchShipQuery> {

    @Autowired
    private TempDispatchShipService tempDispatchService;

    @Autowired
    private AppUserService appUserService;


    /**
     * app上传船信息
     * @param model
     * @return
     */
    @Operation("app上传船信息")
    @RequestMapping(value = "/appAdd", method = RequestMethod.POST)
    public JsonRet<Long> appAdd(@JsonParam TempDispatchShip model)
    {
        model.setFrom(2);
        JsonRet<Long> ret  = tempDispatchService.add(model);
        if (ret.isSuccess())
        {
            AppUser mAppUser = SessionUtil.getAppUser();
            if (mAppUser != null)
            {
                mAppUser.setShipInfoId(ret.getData());
                appUserService.modify(mAppUser);
            }
        }
        return ret;
    }

    @Override
    protected BaseService<TempDispatchShip, TempDispatchShipQuery> getBaseService() {
        return tempDispatchService;
    }

    /**
     * APP端加载
     * @return
     */
    @RequestMapping(value = "/getAppById", method = RequestMethod.GET)
    public JsonRet<Object> getAppById()
    {
        return tempDispatchService.getAppById(SessionUtil.getAppUser());
    }

}
