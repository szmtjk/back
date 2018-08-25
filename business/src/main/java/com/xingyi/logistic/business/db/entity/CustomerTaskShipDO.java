package com.xingyi.logistic.business.db.entity;

/**
 * Created by xiaohu on 2018/8/25.
 */
public class CustomerTaskShipDO {

    private Long taskId;
    private String customerTaskNo;
    private Long customerTaskFlowId;
    private String customerTaskFlowNo;
    private Long shipId;
    private String shipNo;
    private String gpsDeviceId;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getCustomerTaskNo() {
        return customerTaskNo;
    }

    public void setCustomerTaskNo(String customerTaskNo) {
        this.customerTaskNo = customerTaskNo;
    }

    public Long getCustomerTaskFlowId() {
        return customerTaskFlowId;
    }

    public void setCustomerTaskFlowId(Long customerTaskFlowId) {
        this.customerTaskFlowId = customerTaskFlowId;
    }

    public String getCustomerTaskFlowNo() {
        return customerTaskFlowNo;
    }

    public void setCustomerTaskFlowNo(String customerTaskFlowNo) {
        this.customerTaskFlowNo = customerTaskFlowNo;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getGpsDeviceId() {
        return gpsDeviceId;
    }

    public void setGpsDeviceId(String gpsDeviceId) {
        this.gpsDeviceId = gpsDeviceId;
    }
}
