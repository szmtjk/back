package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.TransferFlowPriceDBQuery;
import com.xingyi.logistic.business.db.entity.TransferFlowPriceDO;
import com.xingyi.logistic.business.db.entity.TransferPriceDBQuery;
import com.xingyi.logistic.business.db.entity.TransferPriceDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 运价流向信息
 */
@Dao
public interface TransferFlowPriceDAO extends BaseDAO<TransferFlowPriceDO, TransferFlowPriceDBQuery> {

}
