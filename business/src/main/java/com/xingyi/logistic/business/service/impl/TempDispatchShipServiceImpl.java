package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.TempDispatchShipDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.db.entity.TempDispatchShipDBQuery;
import com.xingyi.logistic.business.db.entity.TempDispatchShipDO;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.model.TempDispatchShip;
import com.xingyi.logistic.business.model.TempDispatchShipQuery;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.TempDispatchShipService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import com.xingyi.logistic.business.service.converter.TempDispatchShipConverter;
import com.xingyi.logistic.business.service.converter.TempDispatchShipQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 临调船舶
 */
@Service
public class TempDispatchShipServiceImpl extends BaseCRUDService<TempDispatchShipDO, TempDispatchShip, TempDispatchShipDBQuery, TempDispatchShipQuery> implements TempDispatchShipService {

    @Autowired
    private TempDispatchShipDAO tempDispatchShipDAO;

    @Autowired
    private TempDispatchShipConverter tempDispatchShipConverter;

    @Autowired
    private TempDispatchShipQueryConverter tempDispatchshipQueryConverter;

    @Override
    protected ModelConverter<TempDispatchShipDO, TempDispatchShip> getModelConverter() {
        return tempDispatchShipConverter;
    }

    @Override
    protected BaseDAO<TempDispatchShipDO, TempDispatchShipDBQuery> getDAO() {
        return tempDispatchShipDAO;
    }

    @Override
    protected QueryConditionConverter<TempDispatchShipQuery, TempDispatchShipDBQuery> getConditionConverter() {
        return tempDispatchshipQueryConverter;
    }
}
