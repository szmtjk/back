package com.xingyi.logistic.authentication.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.aop.annotation.Operation;
import com.xingyi.logistic.authentication.model.*;
import com.xingyi.logistic.authentication.security.User;
import com.xingyi.logistic.authentication.service.*;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import com.xingyi.logistic.controller.BaseCRUDController;
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
@Biz
@RequestMapping("/user")
@RestController
public class UserController extends BaseCRUDController<UserProfile,UserProfileQuery>{
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


	@Operation("新增")
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

    @Operation("修改")
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

    @Operation("删除")
    @RequestMapping(value = "/delUser", method = RequestMethod.POST)
    public JsonRet<Boolean> delUser(@JsonParam UserProfile userProfile) {
        localAuthService.del(userProfile.getLocalId());
        return userProfileService.del(userProfile.getId());
    }

    /**
     * 设置用户角色
     * @param user
     */
    @Operation("设置用户角色")
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
