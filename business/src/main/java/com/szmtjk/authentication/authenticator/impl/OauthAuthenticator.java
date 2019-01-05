package com.szmtjk.authentication.authenticator.impl;

import com.szmtjk.authentication.oauth.weixin.service.WeiXinService;
import com.szmtjk.authentication.authenticator.Authenticator;
import com.szmtjk.authentication.model.OAuth;
import com.szmtjk.authentication.security.Subject;
import com.szmtjk.authentication.service.OAuthService;
import com.szmtjk.authentication.util.ApplicationContextUtil;
import com.szmtjk.authentication.util.DigestUtil;
import com.szmtjk.authentication.util.SessionUtil;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import com.szmtjk.qiangdan.model.AppUser;
import com.szmtjk.qiangdan.service.AppUserService;
import org.apache.commons.lang3.StringUtils;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午3:01.
 */
public class OauthAuthenticator implements Authenticator {
	private AppUserService appUserService;
	private OAuthService oAuthService;
	private WeiXinService weiXinService;

	public OauthAuthenticator(){
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
		Long oauthExpire = oAuth.getOauthExpires();
		String realMd5 = DigestUtil.md5(String.valueOf(appUserId),oauthId,accessToken,String.valueOf(expire));
		if(!StringUtils.equals(md5,realMd5)){
			return jsonRet;
		}

		//第三方 token 过期，刷新第三方 token
		/*if(System.currentTimeMillis() - oauthExpire > 0){
			TokenResult tokenResult = this.weiXinService.refreshToken(oAuth.getRefreshToken());
			if(!tokenResult.isSuccess()){
				return jsonRet;
			}
			oAuth.setOauthId(tokenResult.getOpenid());
			oAuth.setAccessToken(tokenResult.getAccess_token());
			oAuth.setRefreshToken(tokenResult.getRefresh_token());
			oAuth.setOauthExpires(System.currentTimeMillis() + tokenResult.getExpires_in());
			JsonRet<Boolean> oAuthModifyRet = this.oAuthService.modify(oAuth);
			if(!oAuthModifyRet.isSuccess()){
				return jsonRet;
			}
			//生成新 Token
			String newMd5 = DigestUtil.md5(String.valueOf(appUserId),oAuth.getOauthId(),oAuth.getAccessToken(),String.valueOf(expire));
			String newToken = appUserId + ":" + newMd5 + expire;
			newToken = Base64Utils.encodeToString(newToken.getBytes());
			SessionUtil.setToken(newToken);
		}*/

		Subject subject = new Subject(appUser,true);
		SessionUtil.setSubject(subject);
		return JsonRet.getSuccessRet(null);
	}
}
