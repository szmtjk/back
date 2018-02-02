package com.xingyi.logistic.controller;

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
        return tempDispatchService.add(model);
    }

    @Override
    public JsonRet<Long> add(TempDispatchShip tempDispatchShip) {
        return super.add(tempDispatchShip);
    }
    @Override
    public JsonRet<Boolean> modify(TempDispatchShip tempDispatchShip) {
        return super.modify(tempDispatchShip);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<TempDispatchShip> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(TempDispatchShipQuery tempDispatchShipQuery) {
        return super.getList(tempDispatchShipQuery);
    }

    @Override
    protected BaseService<TempDispatchShip, TempDispatchShipQuery> getBaseService() {
        return tempDispatchService;
    }
}
