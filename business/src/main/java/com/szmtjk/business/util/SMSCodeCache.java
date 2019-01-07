package com.szmtjk.business.util;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaohu on 2019/1/7.
 */
@Component
public class SMSCodeCache {

    private static final Logger LOG = LoggerFactory.getLogger(SMSCodeCache.class);

    private LoadingCache<String, String> smsMap = CacheBuilder.newBuilder()
            .maximumSize(10000)
            .expireAfterWrite(15, TimeUnit.MINUTES)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) {
                    return null;
                }
            });

    public void putSMSCode(String mobile, String smsCode) {
        smsMap.put(mobile, smsCode);
    }

    public void removeSMSCode(String mobile) {
        smsMap.invalidate(mobile);
    }

    public String getSMSCode(String mobile) {
        try {
            return smsMap.get(mobile);
        } catch (ExecutionException e) {
            LOG.error("get sms code from cache err, mobile:{}", mobile, e);
            return null;
        }
    }
}
