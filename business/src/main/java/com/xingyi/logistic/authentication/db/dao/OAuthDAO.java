package com.xingyi.logistic.authentication.db.dao;

import com.xingyi.logistic.authentication.db.entity.OAuthDBQuery;
import com.xingyi.logistic.authentication.db.entity.OAuthDO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xxx.boot.jdbc.annotation.Dao;

@Dao
public interface OAuthDAO extends BaseDAO<OAuthDO,OAuthDBQuery> {
	/**
	 * 查询 openid 对应记录
	 * @param oauthId
	 * @return
	 */
	OAuthDO queryByOauthId(String oauthId);

	/**
	 * 查询 userId 对应记录
	 * @param appUserId
	 * @return
	 */
	OAuthDO queryByAppUserId(Long appUserId);
}
