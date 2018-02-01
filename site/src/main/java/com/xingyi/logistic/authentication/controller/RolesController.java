package com.xingyi.logistic.authentication.controller;

import com.xingyi.logistic.authentication.model.ActionResources;
import com.xingyi.logistic.authentication.model.RoleResources;
import com.xingyi.logistic.authentication.model.Roles;
import com.xingyi.logistic.authentication.model.RolesQuery;
import com.xingyi.logistic.authentication.service.RoleResourcesService;
import com.xingyi.logistic.authentication.service.RolesService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/setResources")
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
