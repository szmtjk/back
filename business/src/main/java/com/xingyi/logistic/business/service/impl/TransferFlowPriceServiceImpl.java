package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.TransferFlowPriceDAO;
import com.xingyi.logistic.business.db.dao.TransferPriceDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.TransferFlowPriceDBQuery;
import com.xingyi.logistic.business.db.entity.TransferFlowPriceDO;
import com.xingyi.logistic.business.db.entity.TransferPriceDBQuery;
import com.xingyi.logistic.business.db.entity.TransferPriceDO;
import com.xingyi.logistic.business.model.TransferFlowPrice;
import com.xingyi.logistic.business.model.TransferFlowPriceQuery;
import com.xingyi.logistic.business.model.TransferPrice;
import com.xingyi.logistic.business.model.TransferPriceQuery;
import com.xingyi.logistic.business.service.TransferFlowPriceService;
import com.xingyi.logistic.business.service.TransferPriceService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.TransferFlowPriceConverter;
import com.xingyi.logistic.business.service.converter.TransferFlowPriceQueryConverter;
import com.xingyi.logistic.business.service.converter.TransferPriceConverter;
import com.xingyi.logistic.business.service.converter.TransferPriceQueryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 运价流向信息
 */
@Service
public class TransferFlowPriceServiceImpl extends BaseCRUDService<TransferFlowPriceDO, TransferFlowPrice, TransferFlowPriceDBQuery, TransferFlowPriceQuery> implements TransferFlowPriceService {

    @Autowired
    private TransferFlowPriceDAO transferFlowPriceDAO;

    @Autowired
    private TransferFlowPriceConverter transferFlowPriceConverter;

    @Autowired
    private TransferFlowPriceQueryConverter transferFlowPriceQueryConverter;

    @Override
    protected ModelConverter<TransferFlowPriceDO, TransferFlowPrice> getModelConverter() {
        return transferFlowPriceConverter;
    }

    @Override
    protected BaseDAO<TransferFlowPriceDO, TransferFlowPriceDBQuery> getDAO() {
        return transferFlowPriceDAO;
    }

    @Override
    protected QueryConditionConverter<TransferFlowPriceQuery, TransferFlowPriceDBQuery> getConditionConverter() {
        return transferFlowPriceQueryConverter;
    }

}
