package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.LeftDispatchInfoDO;
import com.xingyi.logistic.business.model.LeftDispatchInfo;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 余量临调信息
 */
@Component
public class LeftDispatchInfoConverter extends ModelConverter<LeftDispatchInfoDO,LeftDispatchInfo> {
    @Override
    public LeftDispatchInfoDO toDataObject(LeftDispatchInfo src) {
        LeftDispatchInfoDO wld = new LeftDispatchInfoDO();
        if (src != null) {
            BeanUtils.copyProperties(src, wld);
        }
        return wld;
    }

    @Override
    public LeftDispatchInfo toModel(LeftDispatchInfoDO src) {
        LeftDispatchInfo dst = new LeftDispatchInfo();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
