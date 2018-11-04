package com.xingyi.logistic.business.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * Created by Jadic on 2017/12/31.
 */
public class JsonUtil {

    public static String toJson(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T toObject(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static <T> T toObject(String json, TypeReference<T> type) {
        return JSON.parseObject(json, type);
    }
}
