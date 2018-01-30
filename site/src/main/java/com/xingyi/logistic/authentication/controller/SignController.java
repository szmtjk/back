package com.xingyi.logistic.authentication.controller;

import com.xingyi.logistic.authentication.OAuthType;
import com.xingyi.logistic.authentication.model.*;
import com.xingyi.logistic.authentication.oauth.weixin.dto.TokenResult;
import com.xingyi.logistic.authentication.oauth.weixin.dto.UserInfoResult;
import com.xingyi.logistic.authentication.oauth.weixin.service.WeiXinService;
import com.xingyi.logistic.authentication.service.LocalAuthService;
import com.xingyi.logistic.authentication.service.OAuthService;
import com.xingyi.logistic.authentication.util.DigestUtil;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.controller.BaseController;
import com.xingyi.logistic.qiangdan.model.AppUser;
import com.xingyi.logistic.qiangdan.service.AppUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午1:02.
 */
@RestController
public class SignController extends BaseController {
	@Autowired
	private LocalAuthService localAuthService;

	@Value("#{30L * 24L * 3600L * 1000L}")
	private long tokenExpire;

	@Autowired
	private WeiXinService weiXinService;

	@Autowired
	private OAuthService oAuthService;

	@Autowired
	private AppUserService appUserService;

	/**
	 * 本地账号 + 密码 登录
	 * @param signName
	 * @param passwd
	 * @return
	 */
	@RequestMapping("/signin/local")
	public JsonRet<Object> localSignIn(@RequestParam(value = "signName",required = true) String signName,@RequestParam(value = "passwd",required = true) String passwd){
		LocalAuthQuery localAuthQuery = new LocalAuthQuery(signName);
		JsonRet<List<LocalAuth>> localAuthRet = this.localAuthService.getList(localAuthQuery);
		List<LocalAuth> localAuthList = localAuthRet.getData();

		//账号不存在
		if(CollectionUtils.isEmpty(localAuthList)){
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_NOT_EXIST.getCode(),ErrCode.AUTHTICATION_NOT_EXIST.getMsg());
		}

		LocalAuth localAuth = localAuthList.get(0);
		String localPasswd = localAuth.getPasswd();
		//密码错误
		if(!StringUtils.equals(passwd,localPasswd)){
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_PASSWD_ERROR.getCode(),ErrCode.AUTHTICATION_PASSWD_ERROR.getMsg());
		}

		Long userId = localAuth.getUserId();

		//下发 Token
		long expire = System.currentTimeMillis() + this.tokenExpire;
		String md5 = DigestUtil.md5(String.valueOf(userId),signName,localPasswd,String.valueOf(expire));
		String token = userId + ":" + md5 + ":" + expire;
		token = Base64Utils.encodeToString(token.getBytes());
		//MTpjM2E0MjY2Y2Y4YzVmNDk1Y2EyYTk5ODA4ZjJmY2Y1ODoxNTE5MTUyMTUyODg0 正确
		//MTpjNDRjODZlZjM2MjIwYzM5NGQ5MmI1YjlhOTgxNGE3OTotMTUxOTE1NTk5MjEzMQ== 过期
		//MjozMTAzODdmNDk3ZTgxODk0OTJmODRiZDU1OGI4ODZkNToxNTE5MTU4MTAzNTU2 非法, 篡改 userId
		//MTpjMDNkNDI4NWJiMGM5ZTBkNzE3OTNhMWFjOTBkMGMwZXg6MTUxOTE1NzYzNzA2OQ== 非法,篡改 MD5

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("token",token);

		return JsonRet.getSuccessRet(params);
	}

    /**
     * 微信登录
     * @return
     */
    @RequestMapping(value = "/signin/oauth/weixin/{code}")
	public JsonRet<Object> weixinSignIn(@PathVariable String code){
        TokenResult tokenResult = this.weiXinService.getToken(code);
        if(!tokenResult.isSuccess()){
            return JsonRet.getErrRet(tokenResult.getErrcode(),tokenResult.getErrmsg());
        }

        String accessToken = tokenResult.getAccess_token();
        String openId = tokenResult.getOpenid();

        OAuth oAuth = new OAuth();
        oAuth.setOauthName(OAuthType.WEIXIN.getCode());
        oAuth.setAccessToken(accessToken);
        oAuth.setOauthId(openId);
        oAuth.setRefreshToken(tokenResult.getRefresh_token());
        oAuth.setScope(tokenResult.getScope());
        oAuth.setOauthExpires(System.currentTimeMillis() + tokenResult.getExpires_in());
	    JsonRet<OAuth> oAuthSaveRet = this.oAuthService.save(oAuth);
	    if(!oAuthSaveRet.isSuccess()){
	    	return JsonRet.getErrRet(oAuthSaveRet.getErrCode(),oAuthSaveRet.getMsg());
	    }

	    AppUser appUser = null;
		Long appUserId = oAuth.getUserId();
	    if(null != appUserId){
	    	JsonRet<AppUser> appUserGetRet = this.appUserService.getById(appUserId);
	    	if(!appUserGetRet.isSuccess()){
	    		return JsonRet.getErrRet(appUserGetRet.getErrCode(),appUserGetRet.getMsg());
		    }
		    appUser = appUserGetRet.getData();
	    }else{
		    appUser = new AppUser();
		    JsonRet<Long> appUserAddRet = this.appUserService.add(appUser);
		    if(!appUserAddRet.isSuccess()){
			    return JsonRet.getErrRet(appUserAddRet.getErrCode(),appUserAddRet.getMsg());
		    }
		    appUserId = appUserAddRet.getData();
		    appUser.setId(appUserId);

		    oAuth.setUserId(appUserId);
		    JsonRet<Boolean> oAuthModifyRet = this.oAuthService.modify(oAuth);
		    if(!oAuthModifyRet.isSuccess()){
			    return JsonRet.getErrRet(oAuthModifyRet.getErrCode(),oAuthModifyRet.getMsg());
		    }
	    }

        UserInfoResult userInfoResult = this.weiXinService.getUserInfo(accessToken,openId);
        if(userInfoResult.isSuccess()){
            appUser.setUserName(userInfoResult.getNickname());
            appUser.setNickName(userInfoResult.getNickname());
            appUser.setSex(userInfoResult.getSex());
            appUser.setCity(userInfoResult.getCity());
            appUser.setProvince(userInfoResult.getProvince());
            appUser.setCountry(userInfoResult.getCountry());
            appUser.setHeadImgUrl(userInfoResult.getHeadimgurl());
            JsonRet<Boolean> appUserModifyRet = this.appUserService.modify(appUser);
	        if(!appUserModifyRet.isSuccess()){
		        return JsonRet.getErrRet(appUserModifyRet.getErrCode(),appUserModifyRet.getMsg());
	        }
            oAuth.setUnionId(userInfoResult.getUnionid());
            JsonRet<Boolean> oAuthModifyRet = this.oAuthService.modify(oAuth);
	        if(!oAuthModifyRet.isSuccess()){
		        return JsonRet.getErrRet(oAuthModifyRet.getErrCode(),oAuthModifyRet.getMsg());
	        }
        }

        //下发 Token
        long expire = System.currentTimeMillis() + this.tokenExpire;
        String md5 = DigestUtil.md5(String.valueOf(appUserId),oAuth.getOauthId(),oAuth.getAccessToken(),String.valueOf(expire));
        String token = appUserId + ":" + md5 + ":" + expire;
        token = Base64Utils.encodeToString(token.getBytes());
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("token",token);
        params.put("appUser",appUser);
	    return JsonRet.getSuccessRet(params);
    }

    /**
     * 退出系统
     */
    @RequestMapping("/signout")
	public JsonRet<Object> signout(){
        SessionUtil.removeSubject();
	    return JsonRet.getSuccessRet(null);
    }
}
