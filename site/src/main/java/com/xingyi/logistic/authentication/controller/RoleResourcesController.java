package com.xingyi.logistic.authentication.controller;

import com.xingyi.logistic.authentication.model.RoleResources;
import com.xingyi.logistic.authentication.model.RoleResourcesQuery;
import com.xingyi.logistic.authentication.service.RoleResourcesService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/roleResources")
@RestController
public class RoleResourcesController extends BaseCRUDController<RoleResources,RoleResourcesQuery> {
    @Autowired
    private RoleResourcesService roleResourcesService;

    @Override
    protected BaseService<RoleResources, RoleResourcesQuery> getBaseService() {
        return this.roleResourcesService;
    }

    /**
     * 分配角色权限
     * @param model
     * @return
     */
    @RequestMapping(value = "/addfly", method = RequestMethod.POST)
    public JsonRet<Boolean> addfly(@JsonParam RoleResources model)
    {
        return roleResourcesService.addfly(model);
    }


    /**
     * 根据角色ID来加载权限
     * @param map
     * @return
     */
    @RequestMapping(value = "/loadResourceByRole", method = RequestMethod.POST)
    public List<Map<String, Object>> loadResourceByRole(@RequestParam Map<String, Object> map )
    {
        return roleResourcesService.queryResourceByRoleInfo(map);
    }
}
