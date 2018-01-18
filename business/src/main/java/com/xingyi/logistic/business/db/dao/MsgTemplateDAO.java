package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.MsgTemplateDBQuery;
import com.xingyi.logistic.business.db.entity.MsgTemplateDO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * 消息模板
 */
@Dao
public interface MsgTemplateDAO extends BaseDAO<MsgTemplateDO, MsgTemplateDBQuery> {

}
