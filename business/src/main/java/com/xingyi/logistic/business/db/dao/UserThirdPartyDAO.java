package com.xingyi.logistic.business.db.dao;

import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.UserThirdPartyDBQuery;
import com.xingyi.logistic.business.db.entity.UserThirdPartyDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * Created by xiaohu on 2018/10/28.
 */
@Dao
public interface UserThirdPartyDAO extends BaseDAO<UserThirdPartyDO, UserThirdPartyDBQuery> {
}
