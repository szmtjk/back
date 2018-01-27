package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.DispatchInfoDO;
import com.xingyi.logistic.business.model.DispatchInfo;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/21.
 */
@Component
public class DispatchInfoConverter extends ModelConverter<DispatchInfoDO, DispatchInfo> {

    @Override
    public DispatchInfoDO toDataObject(DispatchInfo src) {
        DispatchInfoDO dst = new DispatchInfoDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public DispatchInfo toModel(DispatchInfoDO src) {
        DispatchInfo dst = new DispatchInfo();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
