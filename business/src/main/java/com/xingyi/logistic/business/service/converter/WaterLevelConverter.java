package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.WaterLevelDO;
import com.xingyi.logistic.business.model.WaterLevel;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class WaterLevelConverter extends ModelConverter<WaterLevelDO,WaterLevel>{
    @Override
    public WaterLevelDO toDataObject(WaterLevel src) {
        WaterLevelDO wld = new WaterLevelDO();
        if (src != null) {
            BeanUtils.copyProperties(src, wld);
        }
        return wld;
    }

    @Override
    public WaterLevel toModel(WaterLevelDO src) {
        WaterLevel dst = new WaterLevel();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
