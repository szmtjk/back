package com.xingyi.logistic.controller;

import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.db.entity.PushAppMsgDO;
import com.xingyi.logistic.business.model.PushAppMsg;
import com.xingyi.logistic.business.model.PushAppMsgQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.PushAppMsgService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/PushAppMsg")
public class PushAppMsgController extends BaseCRUDController<PushAppMsg,PushAppMsgQuery>{

    @Autowired
    PushAppMsgService pushAppMsgService;

    @Override
    protected BaseService<PushAppMsg, PushAppMsgQuery> getBaseService() {
        return pushAppMsgService;
    }

    @RequestMapping(value = "/getAppById", method = {RequestMethod.GET,RequestMethod.POST})
    public JsonRet<Object> getAppById() {
        return pushAppMsgService.getAppById(SessionUtil.getAppUser());
    }

    @RequestMapping(value = "/getPage", method = {RequestMethod.GET,RequestMethod.POST})
    public JsonRet<Object> getPage(@JsonParam PushAppMsgQuery pushAppMsgQuery) {
        if(null != pushAppMsgQuery){
            if("".equals(pushAppMsgQuery.getKey())){
                pushAppMsgQuery.setKey(null);
            }
        }
        return super.getList(pushAppMsgQuery);
    }

    @RequestMapping(value = "/getListById", method = {RequestMethod.GET,RequestMethod.POST})
    public JsonRet<List<PushAppMsgDO>> getListById(PushAppMsgDO pushAppMsgDO) {
        return pushAppMsgService.getListById(pushAppMsgDO);
    }
}
