package com.szmtjk.authentication.authenticator.impl;

import com.szmtjk.authentication.authenticator.Authenticator;
import com.szmtjk.authentication.model.LocalAuth;
import com.szmtjk.authentication.model.UserProfile;
import com.szmtjk.authentication.security.Subject;
import com.szmtjk.authentication.security.User;
import com.szmtjk.authentication.service.LocalAuthService;
import com.szmtjk.authentication.service.UserProfileService;
import com.szmtjk.authentication.util.ApplicationContextUtil;
import com.szmtjk.authentication.util.DigestUtil;
import com.szmtjk.authentication.util.SessionUtil;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午3:00.
 */
public class LocalAuthenticator implements Authenticator {

	private UserProfileService userProfileService;
	private LocalAuthService localAuthService;

	public LocalAuthenticator(){
		this.userProfileService = (UserProfileService) ApplicationContextUtil.getBean("userProfileServiceImpl");
		this.localAuthService = (LocalAuthService) ApplicationContextUtil.getBean("localAuthServiceImpl");
	}

	@Override
	public JsonRet<Object> authenticate(String token) {
		JsonRet<Object> jsonRet = JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());

		String[] tokenMembers = token.split(":");
		long userId = Long.valueOf(tokenMembers[0]);
		String md5 = tokenMembers[1];
		long expire = Long.valueOf(tokenMembers[2]);

		LocalAuth localAuth = this.localAuthService.queryByUserId(userId);
		if(null == localAuth){
		    return jsonRet;
        }

		String loginName = localAuth.getLoginName();
		String localPasswd = localAuth.getPasswd();
		String realMd5 = DigestUtil.md5(String.valueOf(userId),loginName,localPasswd,String.valueOf(expire));

		if(!StringUtils.equals(md5,realMd5)){
			return jsonRet;
		}

		this.bindUserToSession(userId);

		return JsonRet.getSuccessRet(null);
	}

	private void bindUserToSession(Long userId) {
		JsonRet<UserProfile> profileJsonRet = this.userProfileService.getById(userId);
		UserProfile profile = profileJsonRet.getData();
		User user = new User(profile);
		Subject subject = new Subject(user, true);
		SessionUtil.setSubject(subject);
	}
}
