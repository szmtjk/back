package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.NotNullEmpty;


/**
 * 客户任务
 */
public class BaseCustomerTask extends BaseModelAndDO {

    @NotNullEmpty
    private Long customerId;//
    @NotNullEmpty
    private Long contractId;//合同id
    private String totalLoad;//总载重
    private String description;
    private String contractName;
    private String contractNo;
    private String taskNo;//任务单号
    private Integer selfBuckle;//是否扣网片 1 是 2否

    public Integer getSelfBuckle() {
        return selfBuckle;
    }

    public void setSelfBuckle(Integer selfBuckle) {
        this.selfBuckle = selfBuckle;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(String totalLoad) {
        this.totalLoad = totalLoad;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }
}
