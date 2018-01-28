package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.LeftDispatch4CheckDBQuery;
import com.xingyi.logistic.business.db.entity.LeftDispatch4CheckDO;
import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDBQuery;
import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 余量临调信息
 */
@Dao
public interface LeftDispatchInfoDAO extends BaseDAO<LeftDispatchInfoDO,LeftDispatchInfoDBQuery>{

    int queryLeftDispatch4CheckCount(@Param("pojo")LeftDispatch4CheckDBQuery pojo);

    List<LeftDispatch4CheckDO> queryLeftDispatch4CheckList(@Param("pojo")LeftDispatch4CheckDBQuery pojo);
}
