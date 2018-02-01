package com.xingyi.logistic.authentication.controller;

import com.xingyi.logistic.authentication.model.UserRoles;
import com.xingyi.logistic.authentication.model.UserRolesQuery;
import com.xingyi.logistic.authentication.service.UserRolesService;
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

@RequestMapping("/userRoles")
@RestController
public class UserRolesController extends BaseCRUDController<UserRoles,UserRolesQuery> {

    @Autowired
    private UserRolesService userRolesService;

    /**
     * 设置用户角色
     * @param model
     * @return
     */
    @RequestMapping(value = "/addfly", method = RequestMethod.POST)
    public JsonRet<Boolean> addfly(@JsonParam UserRoles model)
    {
        return userRolesService.addfly(model);
    }


    /**
     * 根据用户加载角色
     * @param map
     * @return
     */
    @RequestMapping(value = "/loadRolesByUserId", method = RequestMethod.POST)
    public List<Map<String, Object>> loadRolesByUserId(@RequestParam Map<String, Object> map )
    {
        return userRolesService.queryRolesByUserIdInfo(map);
    }

    @Override
    protected BaseService<UserRoles, UserRolesQuery> getBaseService() {
        return this.userRolesService;
    }
}
