package com.szmtjk.authentication.authenticator.impl;

import com.szmtjk.authentication.authenticator.AbsAuthenticator;
import com.szmtjk.authentication.model.LocalAuth;
import com.szmtjk.authentication.model.UserProfile;
import com.szmtjk.authentication.security.Subject;
import com.szmtjk.authentication.security.User;
import com.szmtjk.authentication.service.LocalAuthService;
import com.szmtjk.authentication.service.UserProfileService;
import com.szmtjk.authentication.util.DigestUtil;
import com.szmtjk.authentication.util.SessionUtil;
import com.szmtjk.business.util.TokenUtil;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午3:00.
 */
@Service
public class LocalAuthenticator extends AbsAuthenticator {

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private LocalAuthService localAuthService;

	@Override
	public int getUserType() {
		return USER_TYPE_WEB_USER;
	}

	@Override
	public JsonRet<Object> authenticate(String token) {
		JsonRet<Object> jsonRet = JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());

		List<String> tokenMembers = TokenUtil.decodeUserToken(token);
		if (tokenMembers == null || tokenMembers.size() != 4) {
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR);
		}

		int userType = Integer.parseInt(tokenMembers.get(3));
		if (userType != getUserType()) {
			return JsonRet.getSuccessRet(true);
		}

		String sUserId = tokenMembers.get(0);
		if (StringUtils.isBlank(sUserId) || !StringUtils.isNumeric(sUserId)) {
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR);
		}

		String expireStr = tokenMembers.get(2);
		if (StringUtils.isBlank(expireStr) || !StringUtils.isNumeric(expireStr)) {
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR);
		}

		long expire = Long.valueOf(expireStr);
		//验证 token 是否过期
		if (0 < (System.currentTimeMillis() - expire)) {
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_EXPIRE);
		}
		long userId = Long.valueOf(sUserId);
		String md5 = tokenMembers.get(1);

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
