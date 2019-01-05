package com.szmtjk.authentication.authenticator;

import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Base64Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午2:54.
 */
public class AuthenticateChain implements Authenticator {
	private List<Authenticator> authenticators = new ArrayList<Authenticator>();

	public AuthenticateChain addAuthenticator(Authenticator authenticator){
		this.authenticators.add(authenticator);
		return this;
	}

	@Override
	public JsonRet<Object> authenticate(String token) {
		System.out.println(">>>>>>>>>>>>>>>>>进入AuthenticateChain，入参 token=" + token);
		JsonRet<Object> jsonRet = null;
		//token 为空直接返回错误
		if(StringUtils.isBlank(token)){
			System.out.println(">>>>>>>>>>>>>>>>>AuthenticateChain， token为空，返回错误信息");
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());
		}

		token = new String(Base64Utils.decodeFromString(token));
		String[] tokenMembers = token.split(":");

		String userId = tokenMembers[0];
		if(StringUtils.isBlank(userId) || !StringUtils.isNumeric(userId)){
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());
		}

		String expireStr = tokenMembers[2];
		if(StringUtils.isBlank(expireStr) || !StringUtils.isNumeric(expireStr)){
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());
		}

		long expire = Long.valueOf(expireStr);
		//验证 token 是否过期
		if(0 < (System.currentTimeMillis() - expire)){
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_EXPIRE.getCode(),ErrCode.AUTHTICATION_TOKEN_EXPIRE.getMsg());
		}

		for(Authenticator authenticator:authenticators){
			jsonRet = authenticator.authenticate(token);
			if(jsonRet.isSuccess()){
				break;
			}
		}

		return jsonRet;
	}
}
