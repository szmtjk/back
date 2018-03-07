package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.ShipEventDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.db.entity.ShipEventDBQuery;
import com.xingyi.logistic.business.db.entity.ShipEventDO;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipEvent;
import com.xingyi.logistic.business.model.ShipEventQuery;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.ShipEventService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipEventConverter;
import com.xingyi.logistic.business.service.converter.ShipEventQueryConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ShipEventServiceImpl extends BaseCRUDService<ShipEventDO, ShipEvent, ShipEventDBQuery, ShipEventQuery> implements ShipEventService {

    @Autowired
    private ShipEventDAO shipEventDAO;

    @Autowired
    private ShipEventConverter shipEventConverter;

    @Autowired
    private ShipEventQueryConverter shipEventQueryConverter;



    @Override
    protected ModelConverter<ShipEventDO, ShipEvent> getModelConverter() {
        return shipEventConverter;
    }

    @Override
    protected BaseDAO<ShipEventDO, ShipEventDBQuery> getDAO() {
        return shipEventDAO;
    }

    @Override
    protected QueryConditionConverter<ShipEventQuery, ShipEventDBQuery> getConditionConverter() {
        return shipEventQueryConverter;
    }
}
