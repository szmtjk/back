package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.LeftDispatch4CheckQuery;
import com.xingyi.logistic.business.model.LeftDispatchInfo;
import com.xingyi.logistic.business.model.LeftDispatchInfoQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.LeftDispatchInfoService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 余量临调信息
 */
@RestController
@RequestMapping("/leftDispatchInfo")
public class LeftDispatchInfoController extends BaseCRUDController<LeftDispatchInfo,LeftDispatchInfoQuery>{

    @Autowired
    private LeftDispatchInfoService leftDispatchInfoService;


    /**
     * APP端加载
     * @param condition
     * @return
     */
    @RequestMapping("/getAppList")
    public JsonRet<Object> getAppList(@JsonParam LeftDispatchInfoQuery condition)
    {
        condition.setAppFlag("app");
        return super.getList(condition);
    }

    @RequestMapping("/getLeftDispatch4Check")
    public JsonRet<Object> getLeftDispatch4Check(@JsonParam LeftDispatch4CheckQuery query) {
        return leftDispatchInfoService.getLeftDispatch4Check(query);
    }

    @Override
    protected BaseService<LeftDispatchInfo, LeftDispatchInfoQuery> getBaseService() {
        return leftDispatchInfoService;
    }
}
