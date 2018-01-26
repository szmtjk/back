package com.xingyi.logistic.authentication.service.impl;

import com.xingyi.logistic.authentication.db.dao.ActionResourcesDAO;
import com.xingyi.logistic.authentication.db.entity.ActionResourcesDBQuery;
import com.xingyi.logistic.authentication.db.entity.ActionResourcesDO;
import com.xingyi.logistic.authentication.model.ActionResources;
import com.xingyi.logistic.authentication.model.ActionResourcesQuery;
import com.xingyi.logistic.authentication.service.ActionResourcesService;
import com.xingyi.logistic.authentication.service.converter.ActionResourcesConverter;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ActionResourcesQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActionResourcesServiceImpl extends BaseCRUDService<ActionResourcesDO,ActionResources,ActionResourcesDBQuery,ActionResourcesQuery> implements ActionResourcesService {

    @Autowired
    private ActionResourcesDAO actionResourcesDAO;

    @Autowired
    private ActionResourcesConverter actionResourcesConverter;

    @Autowired
    private ActionResourcesQueryConverter actionResourcesQueryConverter;

    @Override
    protected ModelConverter<ActionResourcesDO, ActionResources> getModelConverter() {
        return this.actionResourcesConverter;
    }

    @Override
    protected BaseDAO<ActionResourcesDO, ActionResourcesDBQuery> getDAO() {
        return this.actionResourcesDAO;
    }

    @Override
    protected QueryConditionConverter<ActionResourcesQuery, ActionResourcesDBQuery> getConditionConverter() {
        return this.actionResourcesQueryConverter;
    }

	@Override
	public List<ActionResources> queryByUserId(Long userId) {
    	List<ActionResources> resources = new ArrayList<ActionResources>();
    	List<ActionResourcesDO> resourcesDOList = this.actionResourcesDAO.queryByUserId(userId);
    	if(!CollectionUtils.isEmpty(resourcesDOList)){
    		for(ActionResourcesDO resourcesDO:resourcesDOList){
    			resources.add(this.actionResourcesConverter.toModel(resourcesDO));
		    }
	    }
		return resources;
	}
}
