package com.xingyi.logistic.authentication.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xingyi.logistic.authentication.model.ActionResources;
import com.xingyi.logistic.authentication.model.Roles;
import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.model.UserProfileQuery;
import com.xingyi.logistic.authentication.security.User;
import com.xingyi.logistic.authentication.service.ActionResourcesService;
import com.xingyi.logistic.authentication.service.RolesService;
import com.xingyi.logistic.authentication.service.UserProfileService;
import com.xingyi.logistic.authentication.service.UserRolesService;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 上午2:28.
 */
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

	@Override
	protected BaseService<UserProfile, UserProfileQuery> getBaseService() {
		return this.userProfileService;
	}

    /**
     * 设置用户角色
     * @param user
     */
    @RequestMapping("/setRoles")
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

    @RequestMapping("/info")
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
