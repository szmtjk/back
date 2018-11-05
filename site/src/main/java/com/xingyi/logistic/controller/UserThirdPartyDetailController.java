package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.UserThirdPartyDetail;
import com.xingyi.logistic.business.model.UserThirdPartyDetailQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.UserThirdPartyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 三方信息
 */
@Biz("三方信息")
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
