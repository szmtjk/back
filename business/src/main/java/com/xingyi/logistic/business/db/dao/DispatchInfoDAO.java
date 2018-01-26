package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDO;
import com.xingyi.logistic.business.db.entity.DispatchInfoDBQuery;
import com.xingyi.logistic.business.db.entity.DispatchInfoDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Jadic on 2017/12/31.
 */
@Dao
public interface DispatchInfoDAO extends BaseDAO<DispatchInfoDO, DispatchInfoDBQuery> {

    int getCustomerTaskFlow4DispatchCount(@Param("pojo")CustomerTaskFlow4DispatchDBQuery pojo);

    List<CustomerTaskFlow4DispatchDO> getCustomerTaskFlow4DispatchList(@Param("pojo")CustomerTaskFlow4DispatchDBQuery pojo);

    int updateCustomerTaskStatus(@Param("customerTaskFlowId") long customerTaskFlowId);
}
