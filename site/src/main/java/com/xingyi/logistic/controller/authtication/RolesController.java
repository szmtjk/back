package com.xingyi.logistic.controller.authtication;

import com.xingyi.logistic.authentication.model.Roles;
import com.xingyi.logistic.authentication.model.RolesQuery;
import com.xingyi.logistic.authentication.service.RolesService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/roles")
@RestController
public class RolesController extends BaseCRUDController<Roles,RolesQuery> {

    @Autowired
    private RolesService rolesService;

    @Override
    protected BaseService<Roles, RolesQuery> getBaseService() {
        return this.rolesService;
    }
}
