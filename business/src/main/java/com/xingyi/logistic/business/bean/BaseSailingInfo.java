package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

/**
 * 航次信息
 */
public class BaseSailingInfo extends BaseModelAndDO {

    @NotNullEmpty
    private Long shipId;//船id
    @NotNullEmpty
    private Long orderId;//订单id
    @AllowedNumber(values = {1, 2, 3, 4, 5}, message = "航次信息类型错误")
    private Integer status;//航次信息类型  1：空船到港  2：空船装后  3:重船离港  4：重船到港  5：重船卸后
    private Long arriveSPortTime;//实际到装货港时间
    private Long loadTime;//实际装货时间
    private Long loadWeight;//装货吨位
    private Long preArriveEPortTime;//预计到卸货港时间
    private Long actualArriveEPortTime;//实际到达卸货港时间
    private Long dischargeTime;//实际卸货时间
    private Long dischargeWeight;//实际卸货重量
    private Float dischargeDelayFee;//卸货延迟费用
    private Float allowance;//异常补助
    private Long departPortTime;//离港日期
    private Long startchargeTime;//开始卸货时间
    private String description;//备注
    private String bucklePrice;//扣网片金额
    private String shipNo;
    private String goodsName;
    private String customerName;
    private String orderNo;
    private Float cutWire;//扣钢丝
    private  Float cutOther;//扣其他
    private  String cutOtherDes;//扣其他描述


    private String dispatchType;
    private String preWeight;
    private String preLoad;
    private String preArriveTime;
    private String preSettleAmount;
    private String actualTransferPrice;
    private String settleType;
    private String goodsType;
    private String sender;
    private String receiver;
    private String flowName;
    private String startPortId;
    private String endPortId;

    private String loadCentiPic;
    private String loadExPic;
    private String loadExDes;
    private String dischargeCentiPic;
    private String dischargeExPic;
    private String dischargeExDes;

    private  Float poundBalance;//磅差调整
    private  String poundBalanceDes;//磅差调整原因

    public Float getPoundBalance() {
        return poundBalance;
    }

    public void setPoundBalance(Float poundBalance) {
        this.poundBalance = poundBalance;
    }

    public String getPoundBalanceDes() {
        return poundBalanceDes;
    }

    public void setPoundBalanceDes(String poundBalanceDes) {
        this.poundBalanceDes = poundBalanceDes;
    }

    public String getLoadCentiPic() {
        return loadCentiPic;
    }

    public void setLoadCentiPic(String loadCentiPic) {
        this.loadCentiPic = loadCentiPic;
    }

    public String getLoadExPic() {
        return loadExPic;
    }

    public void setLoadExPic(String loadExPic) {
        this.loadExPic = loadExPic;
    }

    public String getLoadExDes() {
        return loadExDes;
    }

    public void setLoadExDes(String loadExDes) {
        this.loadExDes = loadExDes;
    }

    public String getDischargeCentiPic() {
        return dischargeCentiPic;
    }

    public void setDischargeCentiPic(String dischargeCentiPic) {
        this.dischargeCentiPic = dischargeCentiPic;
    }

    public String getDischargeExPic() {
        return dischargeExPic;
    }

    public void setDischargeExPic(String dischargeExPic) {
        this.dischargeExPic = dischargeExPic;
    }

    public String getDischargeExDes() {
        return dischargeExDes;
    }

    public void setDischargeExDes(String dischargeExDes) {
        this.dischargeExDes = dischargeExDes;
    }

    public String getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(String dispatchType) {
        this.dispatchType = dispatchType;
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

    public String getPreArriveTime() {
        return preArriveTime;
    }

    public void setPreArriveTime(String preArriveTime) {
        this.preArriveTime = preArriveTime;
    }

    public String getPreSettleAmount() {
        return preSettleAmount;
    }

    public void setPreSettleAmount(String preSettleAmount) {
        this.preSettleAmount = preSettleAmount;
    }

    public String getActualTransferPrice() {
        return actualTransferPrice;
    }

    public void setActualTransferPrice(String actualTransferPrice) {
        this.actualTransferPrice = actualTransferPrice;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
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

    public String getFlowName() {
        return flowName;
    }

    public void setFlowName(String flowName) {
        this.flowName = flowName;
    }

    public String getStartPortId() {
        return startPortId;
    }

    public void setStartPortId(String startPortId) {
        this.startPortId = startPortId;
    }

    public String getEndPortId() {
        return endPortId;
    }

    public void setEndPortId(String endPortId) {
        this.endPortId = endPortId;
    }

    public Float getCutWire() {
        return cutWire;
    }

    public void setCutWire(Float cutWire) {
        this.cutWire = cutWire;
    }

    public Float getCutOther() {
        return cutOther;
    }

    public void setCutOther(Float cutOther) {
        this.cutOther = cutOther;
    }

    public String getCutOtherDes() {
        return cutOtherDes;
    }

    public void setCutOtherDes(String cutOtherDes) {
        this.cutOtherDes = cutOtherDes;
    }

    public Long getDepartPortTime() {
        return departPortTime;
    }

    public String getBucklePrice() {
        return bucklePrice;
    }

    public void setBucklePrice(String bucklePrice) {
        this.bucklePrice = bucklePrice;
    }

    public Long getStartchargeTime() {
        return startchargeTime;
    }

    public void setStartchargeTime(Long startchargeTime) {
        this.startchargeTime = startchargeTime;
    }

    public void setDepartPortTime(Long departPortTime) {
        this.departPortTime = departPortTime;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getArriveSPortTime() {
        return arriveSPortTime;
    }

    public void setArriveSPortTime(Long arriveSPortTime) {
        this.arriveSPortTime = arriveSPortTime;
    }

    public Long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(Long loadTime) {
        this.loadTime = loadTime;
    }

    public Long getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(Long loadWeight) {
        this.loadWeight = loadWeight;
    }

    public Long getPreArriveEPortTime() {
        return preArriveEPortTime;
    }

    public void setPreArriveEPortTime(Long preArriveEPortTime) {
        this.preArriveEPortTime = preArriveEPortTime;
    }

    public Long getActualArriveEPortTime() {
        return actualArriveEPortTime;
    }

    public void setActualArriveEPortTime(Long actualArriveEPortTime) {
        this.actualArriveEPortTime = actualArriveEPortTime;
    }

    public Long getDischargeTime() {
        return dischargeTime;
    }

    public void setDischargeTime(Long dischargeTime) {
        this.dischargeTime = dischargeTime;
    }

    public Long getDischargeWeight() {
        return dischargeWeight;
    }

    public void setDischargeWeight(Long dischargeWeight) {
        this.dischargeWeight = dischargeWeight;
    }

    public Float getDischargeDelayFee() {
        return dischargeDelayFee;
    }

    public void setDischargeDelayFee(Float dischargeDelayFee) {
        this.dischargeDelayFee = dischargeDelayFee;
    }

    public Float getAllowance() {
        return allowance;
    }

    public void setAllowance(Float allowance) {
        this.allowance = allowance;
    }

    public String getDescription() {
        return description;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
