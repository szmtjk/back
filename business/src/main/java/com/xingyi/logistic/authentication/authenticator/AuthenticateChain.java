package com.xingyi.logistic.authentication.authenticator;

import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
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
		JsonRet<Object> jsonRet = null;
		//token 为空直接返回错误
		if(StringUtils.isBlank(token)){
			return JsonRet.getErrRet(ErrCode.AUTHTICATION_TOKEN_ERROR.getCode(),ErrCode.AUTHTICATION_TOKEN_ERROR.getMsg());
		}

		//验证 token 是否过期
		token = new String(Base64Utils.decodeFromString(token));
		long expire = Long.valueOf(token.split(":")[2]);
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
