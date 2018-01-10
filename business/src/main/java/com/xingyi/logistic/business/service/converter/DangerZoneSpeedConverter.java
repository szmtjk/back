package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.DangerZoneSpeedDO;
import com.xingyi.logistic.business.model.DangerZoneSpeed;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 危险区域速度
 */
@Component
public class DangerZoneSpeedConverter extends ModelConverter<DangerZoneSpeedDO, DangerZoneSpeed> {
    @Override
    public DangerZoneSpeedDO toDataObject(DangerZoneSpeed src) {
        DangerZoneSpeedDO dst = new DangerZoneSpeedDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public DangerZoneSpeed toModel(DangerZoneSpeedDO src) {
        DangerZoneSpeed dst = new DangerZoneSpeed();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
