package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.TransferPrice;
import com.xingyi.logistic.business.model.TransferPriceQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.TransferPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 运价信息
 */
@Biz("运价信息")
@RestController
@RequestMapping("/transferPrice")
public class TransferPriceController extends BaseCRUDController<TransferPrice, TransferPriceQuery> {

    @Autowired
    private TransferPriceService transferPriceService;

    @Override
    protected BaseService<TransferPrice, TransferPriceQuery> getBaseService() {
        return transferPriceService;
    }
}
