package com.xingyi.logistic.authentication.service.impl;

import com.xingyi.logistic.authentication.db.dao.RolesDAO;
import com.xingyi.logistic.authentication.db.entity.RolesDBQuery;
import com.xingyi.logistic.authentication.db.entity.RolesDO;
import com.xingyi.logistic.authentication.model.Roles;
import com.xingyi.logistic.authentication.model.RolesQuery;
import com.xingyi.logistic.authentication.service.RolesService;
import com.xingyi.logistic.authentication.service.converter.RolesConverter;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.RolesQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl extends BaseCRUDService<RolesDO,Roles,RolesDBQuery,RolesQuery> implements RolesService {

    @Autowired
    private RolesDAO rolesDAO;

    @Autowired
    private RolesConverter rolesConverter;

    @Autowired
    private RolesQueryConverter rolesQueryConverter;

    @Override
    protected ModelConverter<RolesDO, Roles> getModelConverter() {
        return this.rolesConverter;
    }

    @Override
    protected BaseDAO<RolesDO, RolesDBQuery> getDAO() {
        return this.rolesDAO;
    }

    @Override
    protected QueryConditionConverter<RolesQuery, RolesDBQuery> getConditionConverter() {
        return this.rolesQueryConverter;
    }
}
