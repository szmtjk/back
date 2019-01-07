package com.szmtjk.web.controller;

import com.szmtjk.business.model.UserThirdPartyDetail;
import com.szmtjk.business.model.UserThirdPartyDetailQuery;
import com.szmtjk.business.service.base.BaseService;
import com.szmtjk.business.service.UserThirdPartyDetailService;
import com.szmtjk.web.controller.base.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 三方信息
 */
@RestController
@RequestMapping("/userThirdPartyDetail")
public class UserThirdPartyDetailController extends BaseCRUDController<UserThirdPartyDetail, UserThirdPartyDetailQuery> {

    @Autowired
    private UserThirdPartyDetailService userThirdPartyDetailService;

    @Override
    protected BaseService<UserThirdPartyDetail, UserThirdPartyDetailQuery> getBaseService() {
        return userThirdPartyDetailService;
    }
}
