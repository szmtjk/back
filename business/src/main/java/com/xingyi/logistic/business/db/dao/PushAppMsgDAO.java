package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PushAppMsgDBQuery;
import com.xingyi.logistic.business.db.entity.PushAppMsgDO;
import com.xxx.boot.jdbc.annotation.Dao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Dao
public interface PushAppMsgDAO extends BaseDAO<PushAppMsgDO, PushAppMsgDBQuery> {

    PushAppMsgDO getAppById(@Param("id")Long userId);

    List<PushAppMsgDO> getListById(PushAppMsgDO pushAppMsgDO);
}
