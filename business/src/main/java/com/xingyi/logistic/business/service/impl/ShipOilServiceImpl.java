package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ShipOilDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipOilDBQuery;
import com.xingyi.logistic.business.db.entity.ShipOilDO;
import com.xingyi.logistic.business.model.ShipOil;
import com.xingyi.logistic.business.model.ShipOilQuery;
import com.xingyi.logistic.business.service.ShipOilService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ShipOilConverter;
import com.xingyi.logistic.business.service.converter.ShipOilQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wzf on 2018/1/1.
 */
@Service
public class ShipOilServiceImpl extends BaseCRUDService<ShipOilDO, ShipOil, ShipOilDBQuery, ShipOilQuery> implements ShipOilService {

    @Autowired
    private ShipOilDAO shipOilDAO;

    @Autowired
    private ShipOilConverter shipOilConverter;

    @Autowired
    private ShipOilQueryConverter shipOilQueryConverter;

    @Override
    protected ModelConverter<ShipOilDO, ShipOil> getModelConverter() {
        return shipOilConverter;
    }

    @Override
    protected BaseDAO<ShipOilDO, ShipOilDBQuery> getDAO() {
        return shipOilDAO;
    }

    @Override
    protected QueryConditionConverter<ShipOilQuery, ShipOilDBQuery> getConditionConverter() {
        return shipOilQueryConverter;
    }
}
