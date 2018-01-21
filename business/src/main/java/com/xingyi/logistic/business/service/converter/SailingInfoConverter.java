package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.SailingInfoDO;
import com.xingyi.logistic.business.model.SailingInfo;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 航次信息
 */
@Component
public class SailingInfoConverter extends ModelConverter<SailingInfoDO, SailingInfo> {
    @Override
    public SailingInfoDO toDataObject(SailingInfo src) {
        SailingInfoDO dst = new SailingInfoDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public SailingInfo toModel(SailingInfoDO src) {
        SailingInfo dst = new SailingInfo();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
