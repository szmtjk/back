package com.xingyi.logistic.authentication.authenticator.impl;

import com.xingyi.logistic.authentication.authenticator.Authenticator;
import com.xingyi.logistic.authentication.model.OAuth;
import com.xingyi.logistic.authentication.oauth.weixin.dto.TokenResult;
import com.xingyi.logistic.authentication.oauth.weixin.service.WeiXinService;
import com.xingyi.logistic.authentication.security.Subject;
import com.xingyi.logistic.authentication.service.OAuthService;
import com.xingyi.logistic.authentication.util.ApplicationContextUtil;
import com.xingyi.logistic.authentication.util.DigestUtil;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.qiangdan.model.AppUser;
import com.xingyi.logistic.qiangdan.service.AppUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

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
