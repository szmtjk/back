package com.xingyi.logistic.controller.authtication;

import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.model.UserProfileQuery;
import com.xingyi.logistic.authentication.service.UserProfileService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 上午2:28.
 */
@RequestMapping("/user")
@RestController
public class UserController extends BaseCRUDController<UserProfile,UserProfileQuery>{
	@Autowired
	private UserProfileService userProfileService;

	@Override
	protected BaseService<UserProfile, UserProfileQuery> getBaseService() {
		return this.userProfileService;
	}
}
