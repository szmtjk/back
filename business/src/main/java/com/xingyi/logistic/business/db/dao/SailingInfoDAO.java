package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDO;
import com.xingyi.logistic.business.db.entity.SailingInfoDBQuery;
import com.xingyi.logistic.business.db.entity.SailingInfoDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 航次信息
 */
@Dao
public interface SailingInfoDAO extends BaseDAO<SailingInfoDO, SailingInfoDBQuery> {

    /**
     * 加载调度的船
     * @param map
     * @return
     */
    List<Map<String, Object>> queryDispatchShipInfo(@Param("pojo")Map<String, String> map);

    /**
     * 加载未处理的所有调度计划
     * @param map
     * @return
     */
    List<Map<String, Object>> queryUnDealDispatchShipInfo(Map<String, String> map);

    /**
     * 加载所有已调度的船舶任务
     * @param map
     * @return
     */
    List<Map<String, Object>> queryAllDispatchShipTask(Map<String, String> map);

    int getDispatchShipTaskCount(@Param("pojo")SailingInfoDBQuery pojo);

    List<Map<String, Object>> getDispatchShipTaskList(@Param("pojo")SailingInfoDBQuery pojo);

    int getSailingShipTaskCount(@Param("pojo")SailingInfoDBQuery pojo);

    List<Map<String, Object>> getSailingShipTaskList(@Param("pojo")SailingInfoDBQuery pojo);
}
