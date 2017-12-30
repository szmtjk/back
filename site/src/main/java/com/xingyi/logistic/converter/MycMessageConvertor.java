package com.xingyi.logistic.converter;

import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;


/**
 * @author weifuping
 * @created 2016/8/31
 */
public class MycMessageConvertor extends MappingJackson2HttpMessageConverter {

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(JsonRet.class) && super.canWrite(clazz, mediaType);
    }

}
