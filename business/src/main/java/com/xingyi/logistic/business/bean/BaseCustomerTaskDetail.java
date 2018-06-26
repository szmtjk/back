package com.xingyi.logistic.business.bean;

/**
 * Created by xiaohu on 2018/3/21.
 */
public class BaseCustomerTaskDetail {

    private Integer taskStatus;//任务状态
    private String taskNo;//客户单号
    private String fullName;//客户单位
    private String contractName;//合同名
    private String totalLoad;//总吨位
    private String flowName;//流向
    private String goodsName;//货物名称
    private String goodsType;//货物类型
    private String totalWeight;//流向吨位
    private String startPortName;//装货点
    private String loadDate;//装货日期
    private String endPortName;//卸货点
    private String dischargeDate;//卸货日期
    private String shipNo;//船号
    private String shipFlag;//船舶类型
    private String preWeight;//预报吨位
    private String preLoad;//预发吨位
    private String actualTransferPrice;//实际运价
    private String preArriveTime;//空船预计到港时间
    private String arriveSPortTime;//空船实际到港时间
    private String loadTime;//空船实际装货时间
    private String loadWeight;//空船实际装货吨位
    private String preArriveEPortTime;//重船预计到卸货港时间
    private String actualArriveEPortTime;//重船实际到卸货港时间
    private String dischargeTime;//重船实际卸货时间
    private String dischargeWeight;//重船实际卸货吨位
    private String dischargeDelayFee;//卸货延期费
    private String allowance;//异常补助

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(String totalLoad) {
        this.totalLoad = totalLoad;
    }

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(String totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getStartPortName() {
        return startPortName;
    }

    public void setStartPortName(String startPortName) {
        this.startPortName = startPortName;
    }

    public String getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(String loadDate) {
        this.loadDate = loadDate;
    }

    public String getEndPortName() {
        return endPortName;
    }

    public void setEndPortName(String endPortName) {
        this.endPortName = endPortName;
    }

    public String getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getShipFlag() {
        return shipFlag;
    }

    public void setShipFlag(String shipFlag) {
        this.shipFlag = shipFlag;
    }

    public String getPreWeight() {
        return preWeight;
    }

    public void setPreWeight(String preWeight) {
        this.preWeight = preWeight;
    }

    public String getPreLoad() {
        return preLoad;
    }

    public void setPreLoad(String preLoad) {
        this.preLoad = preLoad;
    }

    public String getActualTransferPrice() {
        return actualTransferPrice;
    }

    public void setActualTransferPrice(String actualTransferPrice) {
        this.actualTransferPrice = actualTransferPrice;
    }

    public String getPreArriveTime() {
        return preArriveTime;
    }

    public void setPreArriveTime(String preArriveTime) {
        this.preArriveTime = preArriveTime;
    }

    public String getArriveSPortTime() {
        return arriveSPortTime;
    }

    public void setArriveSPortTime(String arriveSPortTime) {
        this.arriveSPortTime = arriveSPortTime;
    }

    public String getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(String loadTime) {
        this.loadTime = loadTime;
    }

    public String getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(String loadWeight) {
        this.loadWeight = loadWeight;
    }

    public String getPreArriveEPortTime() {
        return preArriveEPortTime;
    }

    public void setPreArriveEPortTime(String preArriveEPortTime) {
        this.preArriveEPortTime = preArriveEPortTime;
    }

    public String getActualArriveEPortTime() {
        return actualArriveEPortTime;
    }

    public void setActualArriveEPortTime(String actualArriveEPortTime) {
        this.actualArriveEPortTime = actualArriveEPortTime;
    }

    public String getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(String dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    public String getDischargeWeight() {
        return dischargeWeight;
    }

    public void setDischargeWeight(String dischargeWeight) {
        this.dischargeWeight = dischargeWeight;
    }

    public String getDischargeDelayFee() {
        return dischargeDelayFee;
    }

    public void setDischargeDelayFee(String dischargeDelayFee) {
        this.dischargeDelayFee = dischargeDelayFee;
    }

    public String getAllowance() {
        return allowance;
    }

    public void setAllowance(String allowance) {
        this.allowance = allowance;
    }
}
