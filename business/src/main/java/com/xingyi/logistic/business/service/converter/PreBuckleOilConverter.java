package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.PortDO;
import com.xingyi.logistic.business.db.entity.PreBuckleOilDO;
import com.xingyi.logistic.business.model.Port;
import com.xingyi.logistic.business.model.PreBuckleOil;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class PreBuckleOilConverter extends ModelConverter<PreBuckleOilDO, PreBuckleOil> {
    @Override
    public PreBuckleOilDO toDataObject(PreBuckleOil src) {
        PreBuckleOilDO dst = new PreBuckleOilDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public PreBuckleOil toModel(PreBuckleOilDO src) {
        PreBuckleOil dst = new PreBuckleOil();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
