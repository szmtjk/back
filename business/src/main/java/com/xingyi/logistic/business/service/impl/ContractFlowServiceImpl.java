package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.ContractDAO;
import com.xingyi.logistic.business.db.dao.ContractFlowDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ContractDBQuery;
import com.xingyi.logistic.business.db.entity.ContractDO;
import com.xingyi.logistic.business.db.entity.ContractFlowDBQuery;
import com.xingyi.logistic.business.db.entity.ContractFlowDO;
import com.xingyi.logistic.business.model.Contract;
import com.xingyi.logistic.business.model.ContractFlow;
import com.xingyi.logistic.business.model.ContractFlowQuery;
import com.xingyi.logistic.business.model.ContractQuery;
import com.xingyi.logistic.business.service.ContractFlowService;
import com.xingyi.logistic.business.service.ContractService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ContractConverter;
import com.xingyi.logistic.business.service.converter.ContractFLowConverter;
import com.xingyi.logistic.business.service.converter.ContractFLowQueryConverter;
import com.xingyi.logistic.business.service.converter.ContractQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 合同流向
 */
@Service
public class ContractFlowServiceImpl extends BaseCRUDService<ContractFlowDO, ContractFlow, ContractFlowDBQuery, ContractFlowQuery> implements ContractFlowService {

    @Autowired
    private ContractFlowDAO contractFlowDAO ;

    @Autowired
    private ContractFLowConverter contractFlowConverter;

    @Autowired
    private ContractFLowQueryConverter contractFLowQueryConverter;

    @Override
    protected ModelConverter<ContractFlowDO, ContractFlow> getModelConverter() {
        return contractFlowConverter;
    }

    @Override
    protected BaseDAO<ContractFlowDO, ContractFlowDBQuery> getDAO() {
        return contractFlowDAO;
    }

    @Override
    protected QueryConditionConverter<ContractFlowQuery, ContractFlowDBQuery> getConditionConverter() {
        return contractFLowQueryConverter;
    }
}
