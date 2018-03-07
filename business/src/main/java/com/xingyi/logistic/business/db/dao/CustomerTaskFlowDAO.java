package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlowDO;
import com.xingyi.logistic.business.model.Combox;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 客户任务流向
 */
@Dao
public interface CustomerTaskFlowDAO extends BaseDAO<CustomerTaskFlowDO, CustomerTaskFlowDBQuery> {

    long queryTotalWeightInfo(@Param("pojo")Map<String, String> map);

    /**
     * 从运价管理中取（客户、合同、流向、时间）
     * @param map
     * @return
     */
    List<Combox> queryUnitPriceInfo(@Param("pojo")Map<String, String> map);

    int updateCustomerTaskStatus4Sailing(@Param("customerTaskFlowId") long customerTaskFlowId);
}
