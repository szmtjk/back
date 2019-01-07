package com.szmtjk.web.authentication.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.szmtjk.authentication.model.ActionResources;
import com.szmtjk.authentication.model.LocalAuth;
import com.szmtjk.authentication.model.Roles;
import com.szmtjk.authentication.model.UserProfile;
import com.szmtjk.authentication.model.UserProfileQuery;
import com.szmtjk.authentication.security.User;
import com.szmtjk.authentication.service.ActionResourcesService;
import com.szmtjk.authentication.service.LocalAuthService;
import com.szmtjk.authentication.service.RolesService;
import com.szmtjk.authentication.service.UserProfileService;
import com.szmtjk.authentication.service.UserRolesService;
import com.szmtjk.authentication.util.SessionUtil;
import com.szmtjk.business.service.base.BaseService;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import com.szmtjk.web.config.JsonParam;
import com.szmtjk.web.controller.base.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 上午2:28.
 */
@RequestMapping("/xyUser")
@RestController
public class XYUserController extends BaseCRUDController<UserProfile,UserProfileQuery>{
	@Autowired
	private UserProfileService userProfileService;
	@Autowired
	private UserRolesService userRolesService;
    @Autowired
    private RolesService rolesService;
    @Autowired
    private ActionResourcesService resourcesService;

    @Autowired
    private LocalAuthService localAuthService;

	@Override
	protected BaseService<UserProfile, UserProfileQuery> getBaseService() {
		return this.userProfileService;
	}

    @Override
    public JsonRet<Long> add(@JsonParam UserProfile userProfile)
    {
        JsonRet<Long> ret = userProfileService.add(userProfile);
        if (ret.isSuccess())
        {
            LocalAuth localAuth = new LocalAuth();
            localAuth.setLoginName(userProfile.getLoginName());
            localAuth.setPasswd(userProfile.getPasswd());
            localAuth.setUserId(ret.getData());
            localAuthService.add(localAuth);
        }
        return ret;
    }

    @Override
    public JsonRet<Boolean> modify(@JsonParam UserProfile userProfile)
    {
        LocalAuth localAuth = new LocalAuth();
        localAuth.setId(userProfile.getLocalId());
        localAuth.setLoginName(userProfile.getLoginName());
        localAuth.setPasswd(userProfile.getPasswd());
        localAuth.setUserId(userProfile.getId());
        localAuthService.modify(localAuth);
        return userProfileService.modify(userProfile);
    }

    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public JsonRet<Boolean> delUser(@JsonParam UserProfile userProfile) {
        localAuthService.del(userProfile.getLocalId());
        return userProfileService.del(userProfile.getId());
    }

    /**
     * 设置用户角色
     * @param user
     */
    @RequestMapping(value = "/setRoles", method = RequestMethod.GET)
    public JsonRet<Object> setRoles(@RequestBody User user){
        Long userId = user.getProfile().getId();
        List<Long> roleIds = new ArrayList<Long>();
        List<Roles> roles = user.getRoles();
        if(!CollectionUtils.isEmpty(roles)){
            for(Roles role:roles){
                roleIds.add(role.getId());
            }
        }
        int effectRows = this.userRolesService.setRoles(userId,roleIds);

        if(effectRows != roleIds.size()){
            return JsonRet.getErrRet(ErrCode.AUTHORITY_SETTING_ERR);
        }

        return JsonRet.getSuccessRet("设置用户角色成功");
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public JsonRet<Object> info(){
    	UserProfile sessionProfile = SessionUtil.getProfile();
	    System.out.println(">>>>>>>>>>>>>>>>>>>sessionProfile=" + JSON.toJSONString(sessionProfile,SerializerFeature.WriteMapNullValue));
        Long sessionUserId = sessionProfile.getId();
	    System.out.println(">>>>>>>>>>>>>>>>>>>sessionUserId=" + sessionUserId);
        JsonRet<UserProfile> profileJsonRet = this.userProfileService.getById(sessionUserId);
        UserProfile profile = profileJsonRet.getData();
        User user = new User(profile);
        List<Roles> rolesList = this.rolesService.queryByUserId(profile.getId());
        user.setRoles(rolesList);
        List<ActionResources> resources = this.resourcesService.queryByUserId(profile.getId());
        user.setResources(resources);
        return JsonRet.getSuccessRet(user);
    }
}
