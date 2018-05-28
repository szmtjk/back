package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
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

}
