package com.szmtjk.web.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.szmtjk.business.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jadic on 2018/1/1.
 */
public class JsonParamArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger LOG = LoggerFactory.getLogger(JsonParamArgumentResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(JsonParam.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String parameterString = getParameterString(webRequest);
        String jsonString = convertToJsonString(parameterString);
        if (StringUtils.isNotEmpty(jsonString)) {
            try {
                return JSON.parseObject(jsonString, parameter.getParameterType());
            } catch (Exception e) {
                LOG.error("parse json err, json:{}", parameter, e);
            }
        }
        return null;
    }

    private String getParameterString(NativeWebRequest webRequest) throws IOException {
        HttpServletRequest httpServletRequest = webRequest.getNativeRequest(HttpServletRequest.class);
        String method = httpServletRequest.getMethod();
        if ("GET".equals(method) || "DELETE".equals("method")) {
            return httpServletRequest.getQueryString();
        }
        String parameterString = getPostString(httpServletRequest);
        if (StringUtils.isEmpty(parameterString)) {
            parameterString = httpServletRequest.getQueryString();
        }
        return StringUtils.isNotEmpty(parameterString) ? parameterString : null;
    }

    private String getPostString(HttpServletRequest httpRequest) throws IOException {
        Map<String, Object> params = new HashMap<>();
        for (String key : httpRequest.getParameterMap().keySet()) {
            params.put(key, httpRequest.getParameter(key));
        }
        if (params.isEmpty()) {
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            BufferedReader br = httpRequest.getReader();

            while ((line = br.readLine()) != null) {
                jsonBuilder.append(line);
            }

            return jsonBuilder.toString();
        }
        return JsonUtil.toJson(params);
    }

    private String convertToJsonString(String parameterString) {
        if (isNotEmptyJsonMapString(parameterString)) {
            return parameterString;
        }
        final Map<String, String> map = new HashMap<>();
        if (StringUtils.isNotEmpty(parameterString)) {
            Arrays.stream(parameterString.split("&")).forEach(o -> splitQueryParameter(o, map));
        }
        if (!CollectionUtils.isEmpty(map)) {
            return JSON.toJSONString(map);
        } else {
            if (JSON.parseObject(parameterString) != null) {
                return parameterString;
            }
            return null;
        }
    }

    private boolean isNotEmptyJsonMapString(String parameterString) {
        if (StringUtils.isNotEmpty(parameterString)) {
            try {
                Map<String, Object> jsonMap = JSON.parseObject(parameterString, new TypeReference<Map<String, Object>>() {
                });
                return !CollectionUtils.isEmpty(jsonMap);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    private void splitQueryParameter(String kv, Map<String, String> map)  {
        final int idx = kv.indexOf("=");
        final String key = idx > 0 ? kv.substring(0, idx) : kv;
        final String value = idx > 0 && kv.length() > idx + 1 ? kv.substring(idx + 1) : null;
        if (StringUtils.isNotEmpty(key) && value != null) {
            try {
                map.put(URLDecoder.decode(key, "utf-8"), URLDecoder.decode(value, "utf-8"));
            } catch (UnsupportedEncodingException e) {
                LOG.error("decode err, kv:{}", kv, e);
            }
        }
    }
}
