package com.xingyi.logistic.controller.authtication;

import com.xingyi.logistic.authentication.model.OAuth;
import com.xingyi.logistic.authentication.model.OAuthQuery;
import com.xingyi.logistic.authentication.service.OAuthService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/oAuth")
@RestController
public class OAuthController extends BaseCRUDController<OAuth,OAuthQuery>{
    @Autowired
    private OAuthService oAuthService;

    @Override
    protected BaseService<OAuth, OAuthQuery> getBaseService() {
        return this.oAuthService;
    }
}
