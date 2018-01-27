package com.xingyi.logistic.authtication.controller;

import com.xingyi.logistic.authentication.model.ActionResources;
import com.xingyi.logistic.authentication.model.ActionResourcesQuery;
import com.xingyi.logistic.authentication.service.ActionResourcesService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/action")
@RestController
public class ActionResourcesController extends BaseCRUDController<ActionResources,ActionResourcesQuery> {
    @Autowired
    private ActionResourcesService actionResourcesService;

    @Override
    protected BaseService<ActionResources, ActionResourcesQuery> getBaseService() {
        return this.actionResourcesService;
    }
}
