package com.szmtjk.web.authentication.controller;

import com.szmtjk.authentication.model.LocalAuth;
import com.szmtjk.authentication.model.LocalAuthQuery;
import com.szmtjk.authentication.service.LocalAuthService;
import com.szmtjk.business.service.base.BaseService;
import com.szmtjk.web.controller.base.BaseCRUDController;
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
