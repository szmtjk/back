package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.PortDAO;
import com.xingyi.logistic.business.db.dao.TransferPriceDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.db.entity.TransferPriceDBQuery;
import com.xingyi.logistic.business.db.entity.TransferPriceDO;
import com.xingyi.logistic.business.model.Port;
import com.xingyi.logistic.business.model.PortQuery;
import com.xingyi.logistic.business.model.TransferPrice;
import com.xingyi.logistic.business.model.TransferPriceQuery;
import com.xingyi.logistic.business.service.PortService;
import com.xingyi.logistic.business.service.TransferPriceService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.PortConverter;
import com.xingyi.logistic.business.service.converter.PortQueryConverter;
import com.xingyi.logistic.business.service.converter.TransferPriceConverter;
import com.xingyi.logistic.business.service.converter.TransferPriceQueryConverter;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 运价信息
 */
@Service
public class TransferPriceServiceImpl extends BaseCRUDService<TransferPriceDO, TransferPrice, TransferPriceDBQuery, TransferPriceQuery> implements TransferPriceService {

    @Autowired
    private TransferPriceDAO transferPriceDAO;

    @Autowired
    private TransferPriceConverter transferPriceConverter;

    @Autowired
    private TransferPriceQueryConverter transferPriceQueryConverter;

    @Override
    protected ModelConverter<TransferPriceDO, TransferPrice> getModelConverter() {
        return transferPriceConverter;
    }

    @Override
    protected BaseDAO<TransferPriceDO, TransferPriceDBQuery> getDAO() {
        return transferPriceDAO;
    }

    @Override
    protected QueryConditionConverter<TransferPriceQuery, TransferPriceDBQuery> getConditionConverter() {
        return transferPriceQueryConverter;
    }

}
