package com.szmtjk.authentication.service.impl;

import com.szmtjk.authentication.db.dao.UserProfileDAO;
import com.szmtjk.authentication.service.UserProfileService;
import com.szmtjk.authentication.service.converter.UserProfileConverter;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.converter.base.ModelConverter;
import com.szmtjk.business.converter.base.QueryConditionConverter;
import com.szmtjk.business.service.converter.UserProfileQueryConverter;
import com.szmtjk.authentication.db.entity.UserProfileDBQuery;
import com.szmtjk.authentication.db.entity.UserProfileDO;
import com.szmtjk.authentication.model.UserProfile;
import com.szmtjk.authentication.model.UserProfileQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 上午1:04.
 */
@Service
public class UserProfileServiceImpl extends BaseCRUDService<UserProfileDO,UserProfile,UserProfileDBQuery,UserProfileQuery> implements UserProfileService {

	@Autowired
	private UserProfileDAO userProfileDAO;

	@Autowired
	private UserProfileConverter userProfileConverter;

	@Autowired
	private UserProfileQueryConverter userProfileQueryConverter;

	@Override
	protected ModelConverter<UserProfileDO, UserProfile> getModelConverter() {
		return this.userProfileConverter;
	}

	@Override
	protected BaseDAO<UserProfileDO, UserProfileDBQuery> getDAO() {
		return this.userProfileDAO;
	}

	@Override
	protected QueryConditionConverter<UserProfileQuery, UserProfileDBQuery> getConditionConverter() {
		return this.userProfileQueryConverter;
	}
}
