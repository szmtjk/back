package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.authentication.db.entity.UserProfileDBQuery;
import com.xingyi.logistic.authentication.model.UserProfileQuery;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 上午2:09.
 */
@Component
public class UserProfileQueryConverter extends QueryConditionConverter<UserProfileQuery,UserProfileDBQuery> {
	@Override
	public UserProfileDBQuery toDOCondition(UserProfileQuery userProfileQuery) {
		UserProfileDBQuery dst = new UserProfileDBQuery();
		if (userProfileQuery != null) {
			paginationConvert(userProfileQuery, dst);
			BeanUtils.copyProperties(userProfileQuery, dst);
		}
		return dst;
	}
}
