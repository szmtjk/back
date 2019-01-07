package com.szmtjk.web.controller;

import com.szmtjk.business.model.UserThirdParty;
import com.szmtjk.business.model.UserThirdPartyQuery;
import com.szmtjk.web.controller.base.BaseCRUDController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 三方信息
 */
@RestController
@RequestMapping("/userThirdParty")
public class UserThirdPartyController extends BaseCRUDController<UserThirdParty, UserThirdPartyQuery> {

}
