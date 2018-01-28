package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.LeftDispatch4CheckDO;
import com.xingyi.logistic.business.model.LeftDispatch4Check;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/21.
 */
@Component
public class LeftDispatch4CheckConverter extends ModelConverter<LeftDispatch4CheckDO, LeftDispatch4Check> {

    @Override
    public LeftDispatch4CheckDO toDataObject(LeftDispatch4Check src) {
        LeftDispatch4CheckDO dst = new LeftDispatch4CheckDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public LeftDispatch4Check toModel(LeftDispatch4CheckDO src) {
        LeftDispatch4Check dst = new LeftDispatch4Check();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
