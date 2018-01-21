package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskDO;
import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.model.Combox;
import com.xingyi.logistic.business.model.CustomerTaskQuery;
import com.xingyi.logistic.business.model.ShipCurrentGpsQuery;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户任务
 */
@Dao
public interface CustomerTaskDAO extends BaseDAO<CustomerTaskDO, CustomerTaskDBQuery> {
    /**
     * 加载客户
     * @return
     */
    List<Combox> queryComboxCustomerInfo();

    List<Combox> loadContractById(@Param("pojo")CustomerTaskQuery customerTaskQuery);

    List<Combox> loadContractFlowByContractId(@Param("pojo")CustomerTaskQuery customerTaskQuery);

}
