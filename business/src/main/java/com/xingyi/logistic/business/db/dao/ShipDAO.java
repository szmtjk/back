package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.db.entity.ShipWithStaffDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Jadic on 2017/12/31.
 */
@Dao
public interface ShipDAO extends BaseDAO<ShipDO, ShipDBQuery> {

    int queryWithStaffCount(@Param("pojo") ShipDBQuery pojo);
    List<ShipWithStaffDO> queryWithStaffList(@Param("pojo") ShipDBQuery pojo);

    int queryReportOneCount(@Param("pojo") ShipDBQuery pojo);
    List<Map<String, Object>> queryReportOneList(@Param("pojo") ShipDBQuery pojo);

    int queryReportFiveCount(@Param("pojo") ShipDBQuery pojo);
    List<Map<String, Object>> queryReportFiveList(@Param("pojo") ShipDBQuery pojo);

    List<Map<String, Object>> queryReportThreeList(String time1, String time2, String time3, String time4);

    List<Map<String, Object>> getReportFour2ThreeList(String time1, String time2);

    List<Map<String, Object>> getReportFour2TwoList(String time1, String time2);

    List<Map<String, Object>> getReportFour2OneList(String time1, String time2, String time3, String time4);

    List<Map<String, Object>> getReportFour2FourList(String time1, String time2);

    List<Map<String, Object>> getReportTwoHeader(@Param("pojo") ShipDBQuery pojo);

    List<Map<String, Object>> getReportTwoList(@Param("pojo") ShipDBQuery pojo);

    ShipDO getAppById(@Param("id") Long userId);
}
