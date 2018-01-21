package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.MsgTemplate;
import com.xingyi.logistic.business.model.MsgTemplateQuery;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.MsgTemplateService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息模板
 */
@RestController
@RequestMapping("/msgTemplate")
public class MsgTemplateController extends BaseCRUDController<MsgTemplate, MsgTemplateQuery> {

    @Autowired
    private MsgTemplateService mgTemplateService;


    @Override
    public JsonRet<Long> add(MsgTemplate msgTemplate) {
        return super.add(msgTemplate);
    }
    @Override
    public JsonRet<Boolean> modify(MsgTemplate msgTemplate) {
        return super.modify(msgTemplate);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<MsgTemplate> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(MsgTemplateQuery msgTemplateQuery) {
        return super.getList(msgTemplateQuery);
    }

    @Override
    protected BaseService<MsgTemplate, MsgTemplateQuery> getBaseService() {
        return mgTemplateService;
    }
}
