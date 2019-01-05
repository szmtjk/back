package com.szmtjk.authentication.db.dao;

import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.authentication.db.entity.OAuthDBQuery;
import com.szmtjk.authentication.db.entity.OAuthDO;
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
