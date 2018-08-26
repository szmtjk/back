package com.xingyi.logistic.controller;

import com.xingyi.logistic.aop.annotation.Biz;
import com.xingyi.logistic.business.model.TransferFlowPrice;
import com.xingyi.logistic.business.model.TransferFlowPriceQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.TransferFlowPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 运价流向信息
 */
@Biz("运价流向信息")
@RestController
@RequestMapping("/transferFlowPrice")
public class TransferFlowPriceController extends BaseCRUDController<TransferFlowPrice, TransferFlowPriceQuery> {

    @Autowired
    private TransferFlowPriceService transferFlowPriceService;

    @Override
    protected BaseService<TransferFlowPrice, TransferFlowPriceQuery> getBaseService() {
        return transferFlowPriceService;
    }
}
