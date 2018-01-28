package com.xingyi.logistic.business.bean;


import javax.validation.constraints.NotNull;

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
    private String startDate;//执行开始日期
    private String endDate;//执行结束日期

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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
