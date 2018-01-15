package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.DangerZoneDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.DangerZoneDBQuery;
import com.xingyi.logistic.business.db.entity.DangerZoneDO;
import com.xingyi.logistic.business.model.DangerZone;
import com.xingyi.logistic.business.model.DangerZoneQuery;
import com.xingyi.logistic.business.service.DangerZoneService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.DangerZoneConverter;
import com.xingyi.logistic.business.service.converter.DangerZoneQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 危险区域
 */
@Service
public class DangerZoneServiceImpl extends BaseCRUDService<DangerZoneDO, DangerZone, DangerZoneDBQuery, DangerZoneQuery> implements DangerZoneService {

    @Autowired
    private DangerZoneDAO dangerZoneDAO ;

    @Autowired
    private DangerZoneConverter dangerZoneConverter;

    @Autowired
    private DangerZoneQueryConverter dangerZoneQueryConverter;

    @Override
    protected ModelConverter<DangerZoneDO, DangerZone> getModelConverter() {
        return dangerZoneConverter;
    }

    @Override
    protected BaseDAO<DangerZoneDO, DangerZoneDBQuery> getDAO() {
        return dangerZoneDAO;
    }

    @Override
    protected QueryConditionConverter<DangerZoneQuery, DangerZoneDBQuery> getConditionConverter() {
        return dangerZoneQueryConverter;
    }
}
