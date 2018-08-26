package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.MsgTemplate;
import com.xingyi.logistic.business.model.MsgTemplateQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.MsgTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息模板
 */
@Biz("消息模板")
@RestController
@RequestMapping("/msgTemplate")
public class MsgTemplateController extends BaseCRUDController<MsgTemplate, MsgTemplateQuery> {

    @Autowired
    private MsgTemplateService mgTemplateService;

    @Override
    protected BaseService<MsgTemplate, MsgTemplateQuery> getBaseService() {
        return mgTemplateService;
    }
}
