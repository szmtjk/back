package com.szmtjk.authentication.service.converter;

import com.szmtjk.authentication.db.entity.UserProfileDO;
import com.szmtjk.authentication.model.UserProfile;
import com.szmtjk.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 上午1:59.
 */
@Component
public class UserProfileConverter extends ModelConverter<UserProfileDO,UserProfile> {
	@Override
	public UserProfileDO toDataObject(UserProfile userProfile) {
		UserProfileDO userProfileDO = new UserProfileDO();
		if(null != userProfile){
			BeanUtils.copyProperties(userProfile, userProfileDO);
		}
		return userProfileDO;
	}

	@Override
	public UserProfile toModel(UserProfileDO data) {
		UserProfile userProfile = new UserProfile();
		if(null != data){
			BeanUtils.copyProperties(data, userProfile);
		}
		return userProfile;
	}
}
