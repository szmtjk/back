package com.szmtjk.business.util;

import com.google.common.collect.Lists;
import com.szmtjk.authentication.util.DigestUtil;
import com.szmtjk.business.model.User;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;

import java.util.List;

public class TokenUtil {

    private static final long TOKEN_EXPIRE_TIME = 30 * 24 * 3600 * 1000L;// token有效期30天

    public static String encodeUserToken(User user) {
        long expire = System.currentTimeMillis() + TOKEN_EXPIRE_TIME;
        String md5 = DigestUtil.md5(String.valueOf(user.getId()), user.getUserName(), String.valueOf(expire));
        String token = user.getId() + ":" + md5 + ":" + expire;
        token = Base64Utils.encodeToString(token.getBytes());
        return token;
    }

    public static List<String> decodeUserToken(String token) {
        if (!StringUtils.isEmpty(token)) {
            token = new String(Base64Utils.decodeFromString(token));
            String[] tokenMembers = token.split(":");
            return Lists.newArrayList(tokenMembers);
        }
        return null;
    }
}
