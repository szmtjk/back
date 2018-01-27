package com.xingyi.logistic.authtication.controller;

import com.xingyi.logistic.authentication.model.UserRoles;
import com.xingyi.logistic.authentication.model.UserRolesQuery;
import com.xingyi.logistic.authentication.service.UserRolesService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/userRoles")
@RestController
public class UserRolesController extends BaseCRUDController<UserRoles,UserRolesQuery> {

    @Autowired
    private UserRolesService userRolesService;

    @Override
    protected BaseService<UserRoles, UserRolesQuery> getBaseService() {
        return this.userRolesService;
    }
}
