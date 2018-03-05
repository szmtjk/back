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
import com.xingyi.logistic.common.bean.JsonRet;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public JsonRet<Long> add(ActionResources actionResources)
    {
        JsonRet<Long> ret = super.add(actionResources);
        if (ret.isSuccess())
        {
            //修改父节点为非叶子节点
            Map<String, Object> map = new HashedMap();
            map.put("parentId", actionResources.getParentId());
            map.put("leafNode", 1);
            actionResourcesDAO.modifyParentLeft(map);
        }
        return ret;
    }


    @Override
    public JsonRet<Boolean> del(Long id)
    {
        JsonRet<Boolean> ret = super.del(id);
        if (ret.isSuccess())
        {
            ActionResourcesDO mObj = actionResourcesDAO.getById(id);
            int nCnt = actionResourcesDAO.qureyParentByIdInfoCnt(mObj.getParentId());
            if (nCnt == 0)
            {
                Map<String, Object> map = new HashedMap();
                map.put("parentId", mObj.getParentId());
                map.put("leafNode", 0);
                actionResourcesDAO.modifyParentLeft(map);
            }

        }
        return ret;
    }

    /**
     * 加载权限树
     * @return
     */
    public List<Map<String, Object >> queryTreeResourcesInfo()
    {
        return actionResourcesDAO.queryTreeResourcesInfo();
    }
}
