package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.ShipStaffDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.db.entity.ShipStaffDBQuery;
import com.xingyi.logistic.business.db.entity.ShipStaffDO;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.model.ShipStaff;
import com.xingyi.logistic.business.model.ShipStaffQuery;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.ShipStaffService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import com.xingyi.logistic.business.service.converter.ShipStaffConverter;
import com.xingyi.logistic.business.service.converter.ShipStaffQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class ShipStaffServiceImpl extends BaseCRUDService<ShipStaffDO, ShipStaff, ShipStaffDBQuery, ShipStaffQuery> implements ShipStaffService {

    @Autowired
    private ShipStaffDAO shipStaffDAO;

    @Autowired
    private ShipStaffConverter shipStaffConverter;

    @Autowired
    private ShipStaffQueryConverter shipStaffQueryConverter;

    @Override
    protected ModelConverter<ShipStaffDO, ShipStaff> getModelConverter() {
        return shipStaffConverter;
    }

    @Override
    protected BaseDAO<ShipStaffDO, ShipStaffDBQuery> getDAO() {
        return shipStaffDAO;
    }

    @Override
    protected QueryConditionConverter<ShipStaffQuery, ShipStaffDBQuery> getConditionConverter() {
        return shipStaffQueryConverter;
    }
}
