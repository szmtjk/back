package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.TransferFlowPriceDO;
import com.xingyi.logistic.business.db.entity.TransferPriceDO;
import com.xingyi.logistic.business.model.TransferFlowPrice;
import com.xingyi.logistic.business.model.TransferPrice;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 运价信息
 */
@Component
public class TransferFlowPriceConverter extends ModelConverter<TransferFlowPriceDO, TransferFlowPrice> {
    @Override
    public TransferFlowPriceDO toDataObject(TransferFlowPrice src) {
        TransferFlowPriceDO dst = new TransferFlowPriceDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public TransferFlowPrice toModel(TransferFlowPriceDO src) {
        TransferFlowPrice dst = new TransferFlowPrice();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
