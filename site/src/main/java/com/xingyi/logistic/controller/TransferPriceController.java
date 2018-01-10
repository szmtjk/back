package com.xingyi.logistic.controller;

import com.xingyi.logistic.business.model.ContractFlow;
import com.xingyi.logistic.business.model.ContractFlowQuery;
import com.xingyi.logistic.business.model.TransferPrice;
import com.xingyi.logistic.business.model.TransferPriceQuery;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.business.service.ContractFlowService;
import com.xingyi.logistic.business.service.TransferPriceService;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 运价信息
 */
@RestController
@RequestMapping("/transferPrice")
public class TransferPriceController extends BaseCRUDController<TransferPrice, TransferPriceQuery> {

    @Autowired
    private TransferPriceService transferPriceService;

    @Override
    public JsonRet<Long> add(TransferPrice transferPrice) {
        return super.add(transferPrice);
    }
    @Override
    public JsonRet<Boolean> modify(TransferPrice transferPrice) {
        return super.modify(transferPrice);
    }

    @Override
    public JsonRet<Boolean> del(Long id) {
        return super.del(id);
    }

    @Override
    public JsonRet<TransferPrice> getById(Long id) {
        return super.getById(id);
    }

    @Override
    public JsonRet<Object> getList(TransferPriceQuery transferPriceQuery) {
        return super.getList(transferPriceQuery);
    }

    @Override
    protected BaseService<TransferPrice, TransferPriceQuery> getBaseService() {
        return transferPriceService;
    }
}
