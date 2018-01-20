package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.TerminalMsgDO;
import com.xingyi.logistic.business.model.TerminalMsg;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TerminalMsgConverter extends ModelConverter<TerminalMsgDO,TerminalMsg> {

    @Override
    public TerminalMsgDO toDataObject(TerminalMsg src) {
        TerminalMsgDO tmd = new TerminalMsgDO();
        if (src != null) {
            BeanUtils.copyProperties(src, tmd);
        }
        return tmd;
    }

    @Override
    public TerminalMsg toModel(TerminalMsgDO src) {
        TerminalMsg dst = new TerminalMsg();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
