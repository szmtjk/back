package com.szmtjk.web.authentication.controller;

import com.szmtjk.authentication.model.ActionResources;
import com.szmtjk.authentication.model.RoleResources;
import com.szmtjk.authentication.model.Roles;
import com.szmtjk.authentication.model.RolesQuery;
import com.szmtjk.authentication.service.RoleResourcesService;
import com.szmtjk.authentication.service.RolesService;
import com.szmtjk.business.service.base.BaseService;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import com.szmtjk.web.controller.base.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/roles")
@RestController
public class RolesController extends BaseCRUDController<Roles,RolesQuery> {

    @Autowired
    private RolesService rolesService;

    @Autowired
    private RoleResourcesService roleResourcesService;

    @Override
    protected BaseService<Roles, RolesQuery> getBaseService() {
        return this.rolesService;
    }

    @RequestMapping(value = "/setResources", method = RequestMethod.GET)
    public JsonRet<Object> setResources(@RequestBody Roles role){
        if(null == role || null == role.getId()){
            return JsonRet.getErrRet(ErrCode.PARAM_INVALID);
        }

        Long roleId = role.getId();
        this.roleResourcesService.deleteByRoleId(roleId);

        List<ActionResources> resources = role.getResources();
        if(!CollectionUtils.isEmpty(resources)){
            RoleResources rr = null;
            JsonRet<Long> addRet = null;
            for(ActionResources resource:resources){
                rr = new RoleResources();
                rr.setRoleId(roleId);
                rr.setResourceId(resource.getId());
                addRet = this.roleResourcesService.add(rr);
                if(!addRet.isSuccess()){
                    return JsonRet.getErrRet(addRet.getErrCode(),addRet.getMsg());
                }
            }
        }

        return JsonRet.getSuccessRet(null);
    }
}
