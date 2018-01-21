package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.MsgTemplateDO;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.model.MsgTemplate;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Jadic on 2018/1/1.
 */
@Component
public class MsgTemplateConverter extends ModelConverter<MsgTemplateDO, MsgTemplate> {
    @Override
    public MsgTemplateDO toDataObject(MsgTemplate src) {
        MsgTemplateDO dst = new MsgTemplateDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public MsgTemplate toModel(MsgTemplateDO src) {
        MsgTemplate dst = new MsgTemplate();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
