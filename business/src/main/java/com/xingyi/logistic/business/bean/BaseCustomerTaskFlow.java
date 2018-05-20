package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;


/**
 * 客户任务流向
 */
public class BaseCustomerTaskFlow extends BaseModelAndDO {

    @NotNullEmpty
    private Long taskId;//客户任务id

    @NotNullEmpty
    private Long flowId;//流向id

    private String goodsName;//货物名称

    @AllowedNumber(values = {1, 2, 3})
    private Integer goodsType; //货物类型  1：熟料  2：散装  3：集装箱

    private Long totalWeight;//总吨位

    private String direction;

    private String sender;//发送方

    private String receiver;//收货单位

    private Long loadingTime;//装货日期

    private Long dischargeTime;//卸货日期

    private Long startPortId;//装货港口

    private Long endPortId;//卸货港口id

    @AllowedNumber(values = {1, 2})
    private Integer loadType;//装货途径  1：大轮  2：场地

    private String bigShipPC;//大轮批次
    private String taskNo;//任务流向单号

    private Float totalLoad;//总载重

    private String arriveLocation;//到达位置

    private Long bigShipArriveTime;//大轮预计达到时间

    private Long bigShipDepartTime;//大轮预计离开时间

    @AllowedNumber(values = {1, 2})
    private Integer selfPick;//是否自提  1：是 2：否

    private Integer sailingArea;//航行区域

    private Float shipSuggestUnitPrice;//船户参考运价

    @AllowedNumber(values = {1, 2, 3})
    private Integer sailingFlag;//航次标识  1：正常  2：散装回程货  3：安吉货
    @AllowedNumber(values = {1, 2})
    private Integer status;
    private Integer taskStatus;

    private String description;//状态 1：启用  2：禁用

    private Integer goodsSubType; //货物子类

    private Integer selfBuckle; //是否扣网片
    private String customerName;

    public Integer getSelfBuckle() {
        return selfBuckle;
    }

    public void setSelfBuckle(Integer selfBuckle) {
        this.selfBuckle = selfBuckle;
    }

    public Integer getGoodsSubType() {
        return goodsSubType;
    }

    public void setGoodsSubType(Integer goodsSubType) {
        this.goodsSubType = goodsSubType;
    }

    public Long getLoadingTime() {
        return loadingTime;
    }

    public void setLoadingTime(Long loadingTime) {
        this.loadingTime = loadingTime;
    }

    public Long getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(Long dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getFlowId() {
        return flowId;
    }

    public void setFlowId(Long flowId) {
        this.flowId = flowId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Long totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }


    public Long getStartPortId() {
        return startPortId;
    }

    public void setStartPortId(Long startPortId) {
        this.startPortId = startPortId;
    }

    public Long getEndPortId() {
        return endPortId;
    }

    public void setEndPortId(Long endPortId) {
        this.endPortId = endPortId;
    }

    public Integer getLoadType() {
        return loadType;
    }

    public void setLoadType(Integer loadType) {
        this.loadType = loadType;
    }

    public String getBigShipPC() {
        return bigShipPC;
    }

    public void setBigShipPC(String bigShipPC) {
        this.bigShipPC = bigShipPC;
    }

    public Float getTotalLoad() {
        return totalLoad;
    }

    public void setTotalLoad(Float totalLoad) {
        this.totalLoad = totalLoad;
    }

    public String getArriveLocation() {
        return arriveLocation;
    }

    public void setArriveLocation(String arriveLocation) {
        this.arriveLocation = arriveLocation;
    }

    public Long getBigShipArriveTime() {
        return bigShipArriveTime;
    }

    public void setBigShipArriveTime(Long bigShipArriveTime) {
        this.bigShipArriveTime = bigShipArriveTime;
    }

    public Long getBigShipDepartTime() {
        return bigShipDepartTime;
    }

    public void setBigShipDepartTime(Long bigShipDepartTime) {
        this.bigShipDepartTime = bigShipDepartTime;
    }

    public Integer getSelfPick() {
        return selfPick;
    }

    public void setSelfPick(Integer selfPick) {
        this.selfPick = selfPick;
    }

    public Integer getSailingArea() {
        return sailingArea;
    }

    public void setSailingArea(Integer sailingArea) {
        this.sailingArea = sailingArea;
    }

    public Float getShipSuggestUnitPrice() {
        return shipSuggestUnitPrice;
    }

    public void setShipSuggestUnitPrice(Float shipSuggestUnitPrice) {
        this.shipSuggestUnitPrice = shipSuggestUnitPrice;
    }

    public Integer getSailingFlag() {
        return sailingFlag;
    }

    public void setSailingFlag(Integer sailingFlag) {
        this.sailingFlag = sailingFlag;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }
}
