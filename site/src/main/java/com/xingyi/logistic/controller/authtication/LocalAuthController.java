package com.xingyi.logistic.controller.authtication;

import com.xingyi.logistic.authentication.model.LocalAuth;
import com.xingyi.logistic.authentication.model.LocalAuthQuery;
import com.xingyi.logistic.authentication.service.LocalAuthService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/localAuth")
@RestController
public class LocalAuthController extends BaseCRUDController<LocalAuth,LocalAuthQuery> {
    @Autowired
    private LocalAuthService localAuthService;

    @Override
    protected BaseService<LocalAuth, LocalAuthQuery> getBaseService() {
        return this.localAuthService;
    }
}
