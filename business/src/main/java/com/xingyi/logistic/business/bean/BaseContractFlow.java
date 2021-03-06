package com.xingyi.logistic.business.bean;


import com.xingyi.logistic.common.annotation.AllowedNumber;

import javax.validation.constraints.NotNull;

/**
 * 合同流向
 */
public class BaseContractFlow extends BaseModelAndDO {

    @NotNull
    private Long contractId;//合同id
    @NotNull
    private Long flowId;//流向id
    private Long unitPrice;//运价
    @AllowedNumber(values = {1, 2})
    private Integer ticketStatus;//开票与否  1：开  2：不开
    private Long lastUnitPrice;//上期合同运价

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
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

    public Integer getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Integer ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Long getLastUnitPrice() {
        return lastUnitPrice;
    }

    public void setLastUnitPrice(Long lastUnitPrice) {
        this.lastUnitPrice = lastUnitPrice;
    }
}
