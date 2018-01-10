package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.DangerZoneDO;
import com.xingyi.logistic.business.model.DangerZone;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 危险区域
 */
@Component
public class DangerZoneConverter extends ModelConverter<DangerZoneDO, DangerZone> {
    @Override
    public DangerZoneDO toDataObject(DangerZone src) {
        DangerZoneDO dst = new DangerZoneDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public DangerZone toModel(DangerZoneDO src) {
        DangerZone dst = new DangerZone();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
