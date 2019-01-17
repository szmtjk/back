package com.szmtjk.authentication.authenticator;

import com.xxx.common.bean.JsonRet;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/22 上午2:54.
 */
public class AuthenticateChainFactory {

    private static final List<Authenticator> authenticators = new ArrayList<>();

    public static void addAuthenticator(Authenticator authenticator) {
        authenticators.add(authenticator);
    }

    public static JsonRet<Object> authenticate(String token) {
        if (!CollectionUtils.isEmpty(authenticators)) {
            for (Authenticator authenticator : authenticators) {
                JsonRet<Object> ret = authenticator.authenticate(token);
                if (!ret.isSuccess()) {
                    return ret;
                }
            }
        }
        return JsonRet.getSuccessRet(true);
    }
}
