package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.DangerZoneSpeedDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.DangerZoneSpeedDBQuery;
import com.xingyi.logistic.business.db.entity.DangerZoneSpeedDO;
import com.xingyi.logistic.business.model.DangerZoneSpeed;
import com.xingyi.logistic.business.model.DangerZoneSpeedQuery;
import com.xingyi.logistic.business.service.DangerZoneSpeedService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.DangerZoneSpeedConverter;
import com.xingyi.logistic.business.service.converter.DangerZoneSpeedQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 危险区域速度
 */
@Service
public class DangerZoneSpeedServiceImpl extends BaseCRUDService<DangerZoneSpeedDO, DangerZoneSpeed, DangerZoneSpeedDBQuery, DangerZoneSpeedQuery> implements DangerZoneSpeedService {

    @Autowired
    private DangerZoneSpeedDAO dangerZoneSpeedDAO ;

    @Autowired
    private DangerZoneSpeedConverter dangerZoneSpeedConverter;

    @Autowired
    private DangerZoneSpeedQueryConverter dangerZoneSpeedQueryConverter;

    @Override
    protected ModelConverter<DangerZoneSpeedDO, DangerZoneSpeed> getModelConverter() {
        return dangerZoneSpeedConverter;
    }

    @Override
    protected BaseDAO<DangerZoneSpeedDO, DangerZoneSpeedDBQuery> getDAO() {
        return dangerZoneSpeedDAO;
    }

    @Override
    protected QueryConditionConverter<DangerZoneSpeedQuery, DangerZoneSpeedDBQuery> getConditionConverter() {
        return dangerZoneSpeedQueryConverter;
    }
}
