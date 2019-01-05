package com.xingyi.logistic.qiangdan.controller;

import com.szmtjk.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import com.szmtjk.qiangdan.model.AppUser;
import com.szmtjk.qiangdan.model.AppUserQuery;
import com.szmtjk.qiangdan.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appUser")
public class AppUserController extends BaseCRUDController<AppUser,AppUserQuery> {

    @Autowired
    private AppUserService appUserService;

    @Override
    protected BaseService<AppUser,AppUserQuery> getBaseService() {
        return this.appUserService;
    }
}
