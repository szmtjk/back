package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class ShipServiceImpl extends BaseCRUDService<ShipDO, Ship, ShipDBQuery, ShipQuery> implements ShipService {

    @Autowired
    private ShipDAO shipDAO;

    @Autowired
    private ShipConverter shipConverter;

    @Autowired
    private ShipQueryConverter shipQueryConverter;

    @Override
    protected ModelConverter<ShipDO, Ship> getModelConverter() {
        return shipConverter;
    }

    @Override
    protected BaseDAO<ShipDO, ShipDBQuery> getDAO() {
        return shipDAO;
    }

    @Override
    protected QueryConditionConverter<ShipQuery, ShipDBQuery> getConditionConverter() {
        return shipQueryConverter;
    }
}
