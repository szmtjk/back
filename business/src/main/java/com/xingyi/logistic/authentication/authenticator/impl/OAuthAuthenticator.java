package com.xingyi.logistic.authentication.authenticator.impl;

import com.xingyi.logistic.authentication.authenticator.Authenticator;
import com.xingyi.logistic.authentication.model.OAuth;
import com.xingyi.logistic.authentication.oauth.weixin.dto.TokenResult;
import com.xingyi.logistic.authentication.oauth.weixin.service.WeiXinService;
import com.xingyi.logistic.authentication.service.OAuthService;
import com.xingyi.logistic.authentication.util.ApplicationContextUtil;
import com.xingyi.logistic.authentication.util.DigestUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.model.AppUser;
import com.xingyi.logistic.qiangdan.service.AppUserService;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午3:01.
 */
public class OAuthAuthenticator implements Authenticator {
	private AppUserService appUserService;
	private OAuthService oAuthService;
	private WeiXinService weiXinService;

	public OAuthAuthenticator(){
		this.appUserService = (AppUserService) ApplicationContextUtil.getBean("appUserServiceImpl");
		this.oAuthService = (OAuthService) ApplicationContextUtil.getBean("oauthServiceImpl");
		this.weiXinService = (WeiXinService) ApplicationContextUtil.getBean("weiXinServiceImpl");
	}
	@Override
	public JsonRet<Object> authenticate(String token) {
		JsonRet<Object> jsonRet = JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());

		String[] tokenMembers = token.split(":");
		long appUserId = Long.valueOf(tokenMembers[0]);
		String md5 = tokenMembers[1];
		long expire = Long.valueOf(tokenMembers[2]);

		JsonRet<AppUser> appUserGetRet = this.appUserService.getById(appUserId);
		if(!appUserGetRet.isSuccess()){
			return jsonRet;
		}
		AppUser appUser = appUserGetRet.getData();
		if(null == appUser){
			return jsonRet;
		}

		OAuth oAuth = this.oAuthService.queryByAppUserId(appUserId);
		String oauthId = oAuth.getOauthId();
		String accessToken = oAuth.getAccessToken();
		String realMd5 = DigestUtil.md5(String.valueOf(appUserId),oauthId,accessToken,String.valueOf(expire));
		if(!StringUtils.equals(md5,realMd5)){
			return jsonRet;
		}

		boolean isValid = this.weiXinService.isValidToken(accessToken,oauthId);
		if(!isValid){
			TokenResult tokenResult = this.weiXinService.refreshToken(oAuth.getRefreshToken());
		}

		return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());
	}
}
