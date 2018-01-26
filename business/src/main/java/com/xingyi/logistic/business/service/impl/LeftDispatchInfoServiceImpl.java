package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.LeftDispatchInfoDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDBQuery;
import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDO;
import com.xingyi.logistic.business.model.LeftDispatchInfo;
import com.xingyi.logistic.business.model.LeftDispatchInfoQuery;
import com.xingyi.logistic.business.service.LeftDispatchInfoService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.LeftDispatchInfoConverter;
import com.xingyi.logistic.business.service.converter.LeftDispatchInfoQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 余量临调信息
 */
@Service
public class LeftDispatchInfoServiceImpl extends BaseCRUDService<LeftDispatchInfoDO,LeftDispatchInfo,LeftDispatchInfoDBQuery,LeftDispatchInfoQuery> implements LeftDispatchInfoService{
    @Autowired
    LeftDispatchInfoDAO leftDispatchInfoDAO;

    @Autowired
    LeftDispatchInfoConverter leftDispatchInfoConverter;

    @Autowired
    LeftDispatchInfoQueryConverter leftDispatchInfoQueryConverter;

    @Override
    protected ModelConverter<LeftDispatchInfoDO, LeftDispatchInfo> getModelConverter() {
        return leftDispatchInfoConverter;
    }

    @Override
    protected BaseDAO<LeftDispatchInfoDO, LeftDispatchInfoDBQuery> getDAO() {
        return leftDispatchInfoDAO;
    }

    @Override
    protected QueryConditionConverter<LeftDispatchInfoQuery, LeftDispatchInfoDBQuery> getConditionConverter() {
        return leftDispatchInfoQueryConverter;
    }
}
