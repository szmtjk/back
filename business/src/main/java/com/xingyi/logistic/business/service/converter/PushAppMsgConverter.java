package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.PushAppMsgDO;
import com.xingyi.logistic.business.model.PushAppMsg;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PushAppMsgConverter extends ModelConverter<PushAppMsgDO,PushAppMsg> {
    @Override
    public PushAppMsgDO toDataObject(PushAppMsg src) {
        PushAppMsgDO wld = new PushAppMsgDO();
        if (src != null) {
            BeanUtils.copyProperties(src, wld);
        }
        return wld;
    }

    @Override
    public PushAppMsg toModel(PushAppMsgDO src) {
        PushAppMsg dst = new PushAppMsg();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
