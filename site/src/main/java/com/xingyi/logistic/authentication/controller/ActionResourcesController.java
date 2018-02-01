package com.xingyi.logistic.authentication.controller;

import com.xingyi.logistic.authentication.model.ActionResources;
import com.xingyi.logistic.authentication.model.ActionResourcesQuery;
import com.xingyi.logistic.authentication.service.ActionResourcesService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/action")
@RestController
public class ActionResourcesController extends BaseCRUDController<ActionResources,ActionResourcesQuery> {
    @Autowired
    private ActionResourcesService actionResourcesService;

    @Override
    protected BaseService<ActionResources, ActionResourcesQuery> getBaseService() {
        return this.actionResourcesService;
    }

    /**
     * 加载所有权限
     * @return
     */
    @RequestMapping("/loadResources")
    public List<Map<String, Object >> queryTreeResourcesInfo()
    {
        List<Map<String, Object >> mArgFlys = actionResourcesService.queryTreeResourcesInfo();
        Map<String, Object> mRootMap = new HashedMap();
        mRootMap.put("id", 0);
        mRootMap.put("name", "所有权限");
        mArgFlys.add(mRootMap);
        return mArgFlys;
    }
}
