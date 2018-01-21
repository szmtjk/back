package com.xingyi.logistic.authentication.service.impl;

import com.xingyi.logistic.authentication.db.dao.UserProfileDAO;
import com.xingyi.logistic.authentication.db.entity.UserProfileDBQuery;
import com.xingyi.logistic.authentication.db.entity.UserProfileDO;
import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.model.UserProfileQuery;
import com.xingyi.logistic.authentication.service.UserProfileService;
import com.xingyi.logistic.authentication.service.converter.UserProfileConverter;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.UserProfileQueryConverter;
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
