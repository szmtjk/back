package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

import java.util.Date;

/**
 * 船舶
 */
public class BaseShip extends BaseModelAndDO {

    @NotNullEmpty
    private String shipNo;//船号
    @AllowedNumber(values = {1, 2})
    private Integer shipFlag;//1：自由船舶  2：挂靠船舶',
    @AllowedNumber(values = {1, 2})
    private Integer shipType;//1：干货船   2：多用途船'
    private Float length;//船长
    private Float width;//船宽
    private Float depth;//船深
    private Long totalWeight;//总吨位
    private Long netWeight;//净重
    private Long loadWeight;//载重吨位
    private Long feeWeight;//计费吨位
    private Long levelAWeight;//A级吨位
    private Long levelBWeight;//B级吨位
    private Long levelCWeight;//C级吨位
    private String buildDate;//建成日期
    private Long customerId;//船舶所属单位
    private String checkRegisterNo;//船检登记号
    private String checkNo;//船检编号
    private String shipID;//船舶识别码
    private String sailingAreaA;//A级航区
    private String sailingAreaB;//B级航区
    private String sailingAreaC;//C级航区
    private String firstRegisterNo;//初次登记号
    private Long sailingDepth;//航深
    private Long buildFactory;//制造厂家
    private String aisID;//AIS识别码
    private String gpsDeviceId;//GPS设备编号
    private String oldShipName;//原船名
    @AllowedNumber(values = {1, 2,3,99})
    private Integer runType;//营运类型  1：集散两用  2：集装箱  3：砂石  99：其他
    private String rebuildDate;//改建日期
    private String insuranceDate;//保险日期
    private String checkDate;//检验日期
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String repairDate;//维修日期
    private String description;//备注
    private Long  sailingArea;//航行区域  1:A级  2:B级  4:C级 数字相加组合可表示多选

    public Long getSailingArea() {
        return sailingArea;
    }

    public void setSailingArea(Long sailingArea) {
        this.sailingArea = sailingArea;
    }

    public String getFirstRegisterNo() {
        return firstRegisterNo;
    }

    public void setFirstRegisterNo(String firstRegisterNo) {
        this.firstRegisterNo = firstRegisterNo;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public Integer getShipFlag() {
        return shipFlag;
    }

    public void setShipFlag(Integer shipFlag) {
        this.shipFlag = shipFlag;
    }

    public Integer getShipType() {
        return shipType;
    }

    public void setShipType(Integer shipType) {
        this.shipType = shipType;
    }

    public Float getLength() {
        return length;
    }

    public void setLength(Float length) {
        this.length = length;
    }

    public Float getWidth() {
        return width;
    }

    public void setWidth(Float width) {
        this.width = width;
    }

    public Float getDepth() {
        return depth;
    }

    public void setDepth(Float depth) {
        this.depth = depth;
    }

    public Long getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Long totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Long getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Long netWeight) {
        this.netWeight = netWeight;
    }

    public Long getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(Long loadWeight) {
        this.loadWeight = loadWeight;
    }

    public Long getFeeWeight() {
        return feeWeight;
    }

    public void setFeeWeight(Long feeWeight) {
        this.feeWeight = feeWeight;
    }

    public Long getLevelAWeight() {
        return levelAWeight;
    }

    public void setLevelAWeight(Long levelAWeight) {
        this.levelAWeight = levelAWeight;
    }

    public Long getLevelBWeight() {
        return levelBWeight;
    }

    public void setLevelBWeight(Long levelBWeight) {
        this.levelBWeight = levelBWeight;
    }

    public Long getLevelCWeight() {
        return levelCWeight;
    }

    public void setLevelCWeight(Long levelCWeight) {
        this.levelCWeight = levelCWeight;
    }

    public String getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(String buildDate) {
        this.buildDate = buildDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCheckRegisterNo() {
        return checkRegisterNo;
    }

    public void setCheckRegisterNo(String checkRegisterNo) {
        this.checkRegisterNo = checkRegisterNo;
    }

    public String getCheckNo() {
        return checkNo;
    }

    public void setCheckNo(String checkNo) {
        this.checkNo = checkNo;
    }

    public String getShipID() {
        return shipID;
    }

    public void setShipID(String shipID) {
        this.shipID = shipID;
    }

    public String getSailingAreaA() {
        return sailingAreaA;
    }

    public void setSailingAreaA(String sailingAreaA) {
        this.sailingAreaA = sailingAreaA;
    }

    public String getSailingAreaB() {
        return sailingAreaB;
    }

    public void setSailingAreaB(String sailingAreaB) {
        this.sailingAreaB = sailingAreaB;
    }

    public String getSailingAreaC() {
        return sailingAreaC;
    }

    public void setSailingAreaC(String sailingAreaC) {
        this.sailingAreaC = sailingAreaC;
    }

    public Long getSailingDepth() {
        return sailingDepth;
    }

    public void setSailingDepth(Long sailingDepth) {
        this.sailingDepth = sailingDepth;
    }

    public Long getBuildFactory() {
        return buildFactory;
    }

    public void setBuildFactory(Long buildFactory) {
        this.buildFactory = buildFactory;
    }

    public String getAisID() {
        return aisID;
    }

    public void setAisID(String aisID) {
        this.aisID = aisID;
    }

    public String getGpsDeviceId() {
        return gpsDeviceId;
    }

    public void setGpsDeviceId(String gpsDeviceId) {
        this.gpsDeviceId = gpsDeviceId;
    }

    public String getOldShipName() {
        return oldShipName;
    }

    public void setOldShipName(String oldShipName) {
        this.oldShipName = oldShipName;
    }

    public Integer getRunType() {
        return runType;
    }

    public void setRunType(Integer runType) {
        this.runType = runType;
    }

    public String getRebuildDate() {
        return rebuildDate;
    }

    public void setRebuildDate(String rebuildDate) {
        this.rebuildDate = rebuildDate;
    }

    public String getInsuranceDate() {
        return insuranceDate;
    }

    public void setInsuranceDate(String insuranceDate) {
        this.insuranceDate = insuranceDate;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }

    public String getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(String repairDate) {
        this.repairDate = repairDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
