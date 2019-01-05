package com.szmtjk.business.db.dao;

import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.db.entity.UserThirdPartyDBQuery;
import com.szmtjk.business.db.entity.UserThirdPartyDO;
import com.xxx.boot.jdbc.annotation.Dao;

/**
 * Created by xiaohu on 2018/10/28.
 */
@Dao
public interface UserThirdPartyDAO extends BaseDAO<UserThirdPartyDO, UserThirdPartyDBQuery> {
}
