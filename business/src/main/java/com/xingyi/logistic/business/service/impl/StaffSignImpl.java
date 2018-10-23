package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.business.db.dao.StaffSignDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.StaffSignDBQuery;
import com.xingyi.logistic.business.db.entity.StaffSignDO;
import com.xingyi.logistic.business.model.StaffSign;
import com.xingyi.logistic.business.model.StaffSignQuery;
import com.xingyi.logistic.business.service.StaffSignService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.StaffSignConverter;
import com.xingyi.logistic.business.service.converter.StaffSignQueryConverter;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
/**
 * Created by wzf on 2018/1/1.
 */
@Service
public class StaffSignImpl extends BaseCRUDService<StaffSignDO, StaffSign, StaffSignDBQuery, StaffSignQuery> implements StaffSignService {

    @Autowired
    private StaffSignDAO StaffSignDAO;

    @Autowired
    private StaffSignConverter StaffSignConverter;

    @Autowired
    private StaffSignQueryConverter StaffSignQueryConverter;

    @Override
    protected ModelConverter<StaffSignDO, StaffSign> getModelConverter() {
        return StaffSignConverter;
    }

    @Override
    protected BaseDAO<StaffSignDO, StaffSignDBQuery> getDAO() {
        return StaffSignDAO;
    }

    @Override
    public JsonRet<List<StaffSign>> getList(StaffSignQuery queryPage)
    {
        UserProfile profile = getCurrentUser();
        if (profile != null) {
            queryPage.setStaffId(profile.getId().intValue());
        }
        return super.getList(queryPage);
    }

    @Override
    public JsonRet<Long> add(StaffSign contractFlow){
        UserProfile profile = getCurrentUser();
        if (profile != null) {
            contractFlow.setStaffId(profile.getId().intValue());
        }
        return super.add(contractFlow);
    }

    @Override
    public JsonRet<Integer> getTotal(StaffSignQuery query) {
        UserProfile profile = getCurrentUser();
        if (profile != null) {
            query.setStaffId(profile.getId().intValue());
        }
        return super.getTotal(query);
    }

    @Override
    public QueryConditionConverter<StaffSignQuery, StaffSignDBQuery> getConditionConverter() {
        return StaffSignQueryConverter;
    }

}
