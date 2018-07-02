package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDO;
import com.xingyi.logistic.business.db.entity.DispatchInfoDBQuery;
import com.xingyi.logistic.business.db.entity.DispatchInfoDO;
import com.xingyi.logistic.business.model.Combox;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Jadic on 2017/12/31.
 */
@Dao
public interface DispatchInfoDAO extends BaseDAO<DispatchInfoDO, DispatchInfoDBQuery> {

    int getCustomerTaskFlow4DispatchCount(@Param("pojo")CustomerTaskFlow4DispatchDBQuery pojo);

    List<CustomerTaskFlow4DispatchDO> getCustomerTaskFlow4DispatchList(@Param("pojo")CustomerTaskFlow4DispatchDBQuery pojo);

    int updateCustomerTaskStatus4Dispatch(@Param("customerTaskFlowId") long customerTaskFlowId);

    int updateDispatchInfoStatus(@Param("dispatchInfoId") long dispatchInfoId, @Param("status") int status);


    /**
     * 加载调度单号
     * @return
     */
    List<Map<String,Object>> getDispatchInfoInfo(@Param("pojo")DispatchInfoDBQuery pojo);

}
