package com.xingyi.logistic.business.service.converter;

import com.xingyi.logistic.business.db.entity.ContractDO;
import com.xingyi.logistic.business.db.entity.TransferPriceDO;
import com.xingyi.logistic.business.model.Contract;
import com.xingyi.logistic.business.model.TransferPrice;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 运价信息
 */
@Component
public class TransferPriceConverter extends ModelConverter<TransferPriceDO, TransferPrice> {
    @Override
    public TransferPriceDO toDataObject(TransferPrice src) {
        TransferPriceDO dst = new TransferPriceDO();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }

    @Override
    public TransferPrice toModel(TransferPriceDO src) {
        TransferPrice dst = new TransferPrice();
        if (src != null) {
            BeanUtils.copyProperties(src, dst);
        }
        return dst;
    }
}
