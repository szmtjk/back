package com.xingyi.logistic.authentication.service.impl;

import com.xingyi.logistic.authentication.db.dao.OAuthDAO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void deleteByRoleId(Long roleId) {
        this.roleResourcesDAO.deleteByRoleId(roleId);
    }
}
