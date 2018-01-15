package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.TransferFlowPrice;
import com.xingyi.logistic.business.model.TransferFlowPriceQuery;
import com.xingyi.logistic.business.model.TransferPrice;
import com.xingyi.logistic.business.model.TransferPriceQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.TransferFlowPriceService;
import com.xingyi.logistic.business.service.TransferPriceService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 运价流向信息
 */
@RestController
@RequestMapping("/transferFlowPrice")
public class TransferFlowPriceController extends BaseCRUDController<TransferFlowPrice, TransferFlowPriceQuery> {

    @Autowired
    private TransferFlowPriceService transferFlowPriceService;

    @Override
    public JsonRet<Long> add(TransferFlowPrice transferFlowPrice) {
        return super.add(transferFlowPrice);
    }
    @Override
    public JsonRet<Boolean> modify(TransferFlowPrice transferFlowPrice) {
        return super.modify(transferFlowPrice);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<TransferFlowPrice> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(TransferFlowPriceQuery transferFlowPriceQuery) {
        return super.getList(transferFlowPriceQuery);
    }

    @Override
    protected BaseService<TransferFlowPrice, TransferFlowPriceQuery> getBaseService() {
        return transferFlowPriceService;
    }
}
