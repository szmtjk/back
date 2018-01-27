package com.xingyi.logistic.authtication.controller;

import com.xingyi.logistic.authentication.model.RoleResources;
import com.xingyi.logistic.authentication.model.RoleResourcesQuery;
import com.xingyi.logistic.authentication.service.RoleResourcesService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/roleResources")
@RestController
public class RoleResourcesController extends BaseCRUDController<RoleResources,RoleResourcesQuery> {
    @Autowired
    private RoleResourcesService roleResourcesService;

    @Override
    protected BaseService<RoleResources, RoleResourcesQuery> getBaseService() {
        return this.roleResourcesService;
    }
}
