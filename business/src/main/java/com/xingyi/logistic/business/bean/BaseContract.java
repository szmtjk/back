package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

/**
 * Created by Jadic on 2017/12/31.
 */
public class BaseContract extends BaseModelAndDO {
    private String contractNo;

    @NotNullEmpty
    private String name;

    private Integer partyA;

    private String partyB;

    private String validSDate;

    private String validEDate;

    private Long deposit;

    private String depositDate;

    private String depositFinanceDate;

    @AllowedNumber(values = {1, 2})
    private Integer type; //合同类型  1：短期  2：长期

    private Integer goodsType;

    private Integer goodsSubType;

    private Long signDepartment;

    private Long signPerson;

    private Long cheyun;

    private Integer settleType;

    public Integer getSettleType() {
        return settleType;
    }

    public void setSettleType(Integer settleType) {
        this.settleType = settleType;
    }

    @AllowedNumber(values = {1, 2})
    private Integer status; //状态 1：启用  2：禁用

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPartyA() {
        return partyA;
    }

    public void setPartyA(Integer partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public String getValidSDate() {
        return validSDate;
    }

    public void setValidSDate(String validSDate) {
        this.validSDate = validSDate;
    }

    public String getValidEDate() {
        return validEDate;
    }

    public void setValidEDate(String validEDate) {
        this.validEDate = validEDate;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public String getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(String depositDate) {
        this.depositDate = depositDate;
    }

    public String getDepositFinanceDate() {
        return depositFinanceDate;
    }

    public void setDepositFinanceDate(String depositFinanceDate) {
        this.depositFinanceDate = depositFinanceDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getSignDepartment() {
        return signDepartment;
    }

    public void setSignDepartment(Long signDepartment) {
        this.signDepartment = signDepartment;
    }

    public Long getSignPerson() {
        return signPerson;
    }

    public void setSignPerson(Long signPerson) {
        this.signPerson = signPerson;
    }

    public Long getCheyun() {
        return cheyun;
    }

    public void setCheyun(Long cheyun) {
        this.cheyun = cheyun;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsSubType() {
        return goodsSubType;
    }

    public void setGoodsSubType(Integer goodsSubType) {
        this.goodsSubType = goodsSubType;
    }
}
