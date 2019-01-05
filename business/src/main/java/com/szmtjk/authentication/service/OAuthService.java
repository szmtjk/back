package com.szmtjk.authentication.service;

import com.szmtjk.authentication.model.OAuth;
import com.szmtjk.authentication.model.OAuthQuery;
import com.szmtjk.business.service.BaseService;
import com.xxx.common.bean.JsonRet;

/**
 * @author tsingtao_tung@163.com
 */
public interface OAuthService extends BaseService<OAuth,OAuthQuery> {
	/**
	 * 保存
	 *      1. 数据库存在 openid 更新
	 *      2. 数据库不存在 openid 插入
	 * @param oAuth
	 * @return
	 */
	JsonRet<OAuth> save(OAuth oAuth);

	/**
	 * 根据第三方 openid 查询
	 * @param oauthId
	 * @return
	 */
	OAuth queryByOauthId(String oauthId);

	/**
	 * 根据 appUserId 查询
	 * @param appUserId
	 * @return
	 */
	OAuth queryByAppUserId(Long appUserId);
}
