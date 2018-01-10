package com.xingyi.logistic.business.bean;


import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 运价流向信息
 */
public class BaseTransferFlowPrice extends BaseModelAndDO {
    @NotNull
    private Long transferPriceId;//运价信息id
    @NotNull
    private Long flowId; // 流向编号
    private Long unitPrice;//运价
    private Long suggestUnitPrice;//参考运价
    private Date startDate;//执行开始日期
    private Date endDate;//执行结束日期

    public Long getTransferPriceId() {
        return transferPriceId;
    }

    public void setTransferPriceId(Long transferPriceId) {
        this.transferPriceId = transferPriceId;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public Long getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Long unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Long getSuggestUnitPrice() {
        return suggestUnitPrice;
    }

    public void setSuggestUnitPrice(Long suggestUnitPrice) {
        this.suggestUnitPrice = suggestUnitPrice;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
