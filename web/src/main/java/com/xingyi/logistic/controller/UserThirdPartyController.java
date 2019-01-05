package com.xingyi.logistic.controller;

import com.szmtjk.business.model.UserThirdParty;
import com.szmtjk.business.model.UserThirdPartyQuery;
import com.szmtjk.business.service.BaseService;
import com.szmtjk.business.service.UserThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 三方信息
 */
@RestController
@RequestMapping("/userThirdParty")
public class UserThirdPartyController extends BaseCRUDController<UserThirdParty, UserThirdPartyQuery> {

    @Autowired
    private UserThirdPartyService userThirdPartyService;

    @Override
    protected BaseService<UserThirdParty, UserThirdPartyQuery> getBaseService() {
        return userThirdPartyService;
    }
}
