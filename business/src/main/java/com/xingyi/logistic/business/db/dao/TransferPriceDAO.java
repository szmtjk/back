package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.db.entity.TransferPriceDBQuery;
import com.xingyi.logistic.business.db.entity.TransferPriceDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

/**
 * 运价信息
 */
@Dao
public interface TransferPriceDAO extends BaseDAO<TransferPriceDO, TransferPriceDBQuery> {

}
