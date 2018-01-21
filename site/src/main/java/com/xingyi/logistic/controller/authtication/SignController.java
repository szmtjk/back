package com.xingyi.logistic.controller.authtication;

import com.xingyi.logistic.authentication.model.LocalAuth;
import com.xingyi.logistic.authentication.model.LocalAuthQuery;
import com.xingyi.logistic.authentication.model.UserProfile;
import com.xingyi.logistic.authentication.security.Subject;
import com.xingyi.logistic.authentication.security.User;
import com.xingyi.logistic.authentication.service.LocalAuthService;
import com.xingyi.logistic.authentication.service.UserProfileService;
import com.xingyi.logistic.authentication.util.SessionUtil;
import com.xingyi.logistic.authentication.util.TokenUtil;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.controller.BaseController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	@Autowired
	private UserProfileService userProfileService;

	@Value("#{30L * 24L * 3600L * 1000L}")
	private long tokenExpire;

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
		JsonRet<UserProfile> profileJsonRet = this.userProfileService.getById(userId);
		UserProfile profile = profileJsonRet.getData();

		//将用户信息绑定到当前线程
		User user = new User(profile);
		Subject subject = new Subject(user,true);
		SessionUtil.getSession().setSubject(subject);

		//下发 Token
		long expire = System.currentTimeMillis() + this.tokenExpire;
		String md5 = TokenUtil.build(String.valueOf(userId),signName,localPasswd,String.valueOf(expire));
		String token = userId + ":" + md5 + ":" + expire;
		token = Base64Utils.encodeToString(token.getBytes());
		//MTpjM2E0MjY2Y2Y4YzVmNDk1Y2EyYTk5ODA4ZjJmY2Y1ODoxNTE5MTUyMTUyODg0 正确
		//MTpjNDRjODZlZjM2MjIwYzM5NGQ5MmI1YjlhOTgxNGE3OTotMTUxOTE1NTk5MjEzMQ== 过期
		//MjozMTAzODdmNDk3ZTgxODk0OTJmODRiZDU1OGI4ODZkNToxNTE5MTU4MTAzNTU2 非法, 篡改 userId
		//MTpjMDNkNDI4NWJiMGM5ZTBkNzE3OTNhMWFjOTBkMGMwZXg6MTUxOTE1NzYzNzA2OQ== 非法,篡改 MD5

		Map<String,Object> params = new HashMap<String,Object>();
		params.put("user",user);
		params.put("token",token);

		return JsonRet.getSuccessRet(params);
	}
}
