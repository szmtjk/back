package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskDO;
import com.xingyi.logistic.business.db.entity.CustomerTaskDetailDO;
import com.xingyi.logistic.business.model.Combox;
import com.xingyi.logistic.business.model.CustomerTaskQuery;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 客户任务
 */
@Dao
public interface CustomerTaskDAO extends BaseDAO<CustomerTaskDO, CustomerTaskDBQuery> {
    /**
     * 加载客户
     * @return
     */
    List<Combox> queryComboxCustomerInfo(@Param("pojo")Map<String, Object> map);

    List<Combox> loadContractById(@Param("pojo")CustomerTaskQuery customerTaskQuery);

    List<Combox> loadContractFlowByContractId(@Param("pojo")CustomerTaskQuery customerTaskQuery);

    Integer getTaskDetailCount(@Param("key")String key);

    List<CustomerTaskDetailDO> getTaskDetailByPage(@Param("pojo")CustomerTaskDBQuery query);

    int updateCustomerTaskStatus(@Param("taskId")long taskId);
}
