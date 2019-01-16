package com.szmtjk.authentication.service.impl;

import com.szmtjk.authentication.model.RolesQuery;
import com.szmtjk.business.service.converter.RolesQueryConverter;
import com.szmtjk.authentication.db.dao.RolesDAO;
import com.szmtjk.authentication.db.entity.RolesDBQuery;
import com.szmtjk.authentication.db.entity.RolesDO;
import com.szmtjk.authentication.model.Roles;
import com.szmtjk.authentication.service.RolesService;
import com.szmtjk.authentication.service.converter.RolesConverter;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.converter.base.ModelConverter;
import com.szmtjk.business.converter.base.QueryConditionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<Roles> queryByUserId(Long userId) {
    	List<Roles> roles = new ArrayList<Roles>();
    	List<RolesDO> rolesDOList = this.rolesDAO.queryByUserId(userId);
    	if(!CollectionUtils.isEmpty(rolesDOList)){
    		for(RolesDO rolesDO:rolesDOList){
    			roles.add(this.rolesConverter.toModel(rolesDO));
		    }
	    }
		return roles;
	}
}
