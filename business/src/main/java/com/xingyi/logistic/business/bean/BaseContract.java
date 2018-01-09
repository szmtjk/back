package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Jadic on 2017/12/31.
 */
public class BaseContract extends BaseModelAndDO {
    private String contractNo;

    @NotNullEmpty
    private String name;

    private String partyA;

    private String partyB;

    private Date validsDate;

    private Date valideDate;

    private Long deposit;

    private Date depositDate;

    private Date depositFinanceDate;

    @AllowedNumber(values = {1, 2})
    private Integer type; //合同类型  1：短期  2：长期

    private Long signDepartment;

    private Long signPerson;

    private Long cheyun;

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

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public Date getValidsDate() {
        return validsDate;
    }

    public void setValidsDate(Date validsDate) {
        this.validsDate = validsDate;
    }

    public Date getValideDate() {
        return valideDate;
    }

    public void setValideDate(Date valideDate) {
        this.valideDate = valideDate;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Date getDepositDate() {
        return depositDate;
    }

    public void setDepositDate(Date depositDate) {
        this.depositDate = depositDate;
    }

    public Date getDepositFinanceDate() {
        return depositFinanceDate;
    }

    public void setDepositFinanceDate(Date depositFinanceDate) {
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
}
