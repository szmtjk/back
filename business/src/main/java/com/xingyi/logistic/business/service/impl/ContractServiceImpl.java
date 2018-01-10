package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ContractDAO;
import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ContractDBQuery;
import com.xingyi.logistic.business.db.entity.ContractDO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.model.Contract;
import com.xingyi.logistic.business.model.ContractQuery;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.ContractService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ContractConverter;
import com.xingyi.logistic.business.service.converter.ContractQueryConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 合同信息
 */
@Service
public class ContractServiceImpl extends BaseCRUDService<ContractDO, Contract, ContractDBQuery, ContractQuery> implements ContractService {

    @Autowired
    private ContractDAO contractDAO ;

    @Autowired
    private ContractConverter contractConverter;

    @Autowired
    private ContractQueryConverter contractQueryConverter;

    @Override
    protected ModelConverter<ContractDO, Contract> getModelConverter() {
        return contractConverter;
    }

    @Override
    protected BaseDAO<ContractDO, ContractDBQuery> getDAO() {
        return contractDAO;
    }

    @Override
    protected QueryConditionConverter<ContractQuery, ContractDBQuery> getConditionConverter() {
        return contractQueryConverter;
    }
}
