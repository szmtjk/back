package com.xingyi.logistic.authentication.service.impl;

import com.xingyi.logistic.authentication.db.dao.RoleResourcesDAO;
import com.xingyi.logistic.authentication.db.entity.RoleResourcesDBQuery;
import com.xingyi.logistic.authentication.db.entity.RoleResourcesDO;
import com.xingyi.logistic.authentication.model.RoleResources;
import com.xingyi.logistic.authentication.model.RoleResourcesQuery;
import com.xingyi.logistic.authentication.service.RoleResourcesService;
import com.xingyi.logistic.authentication.service.converter.RoleResourcesConverter;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.RoleResourcesQueryConverter;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleResourcesServiceImpl extends BaseCRUDService<RoleResourcesDO,RoleResources,RoleResourcesDBQuery,RoleResourcesQuery> implements RoleResourcesService {

    @Autowired
    private RoleResourcesDAO roleResourcesDAO;

    @Autowired
    private RoleResourcesConverter roleResourcesConverter;

    @Autowired
    private RoleResourcesQueryConverter roleResourcesQueryConverter;

    @Override
    protected ModelConverter<RoleResourcesDO, RoleResources> getModelConverter() {
        return this.roleResourcesConverter;
    }

    @Override
    protected BaseDAO<RoleResourcesDO, RoleResourcesDBQuery> getDAO() {
        return this.roleResourcesDAO;
    }

    @Override
    protected QueryConditionConverter<RoleResourcesQuery, RoleResourcesDBQuery> getConditionConverter() {
        return this.roleResourcesQueryConverter;
    }


    /**
     * 分配角色权限
     * @param model
     * @return
     */
    public JsonRet<Boolean> addfly(RoleResources model)
    {
        JsonRet<Boolean> ret = new JsonRet<>();

        //先删除角色所对应的所有权限
        this.roleResourcesDAO.deleteByRoleId(model.getRoleId());
        if (!"".equals(model.getPids()) && model.getPids() != null)
        {
            String[] pidFly = model.getPids().split("\\,");
            for (String pid : pidFly)
            {
                model.setResourceId(Long.parseLong(pid));
                super.add(model);
            }
        }
        ret.setSuccess(true);
        ret.setSuccessData(true);
        return ret;
    }

    /**
     * 根据角色ID来加载权限
     * @param map
     * @return
     */
    public List<Map<String, Object>> queryResourceByRoleInfo(Map<String, Object> map)
    {
        return roleResourcesDAO.queryResourceByRoleInfo(map);
    }

    @Override
    public void deleteByRoleId(Long roleId) {
        this.roleResourcesDAO.deleteByRoleId(roleId);
    }
}
