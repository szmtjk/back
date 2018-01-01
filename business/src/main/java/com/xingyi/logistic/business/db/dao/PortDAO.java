package com.xingyi.logistic.business.db.dao;

import com.xxx.boot.jdbc.annotation.Dao;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.PortDBQuery;
import com.xingyi.logistic.business.db.entity.PortDO;

/**
 * Created by Jadic on 2017/12/31.
 */
@Dao
public interface PortDAO extends BaseDAO<PortDO, PortDBQuery> {

    PortDO getByName(String name);
}
