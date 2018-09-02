package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

/**
 * 临调船舶
 */
public class BaseTempDispatchShip extends BaseModelAndDO {

    @NotNullEmpty
    private String shipNo;//船号
    private String name;//
    private String mobile;//手机
    private Long preLoad;//预报吨位
    private String identity;//身份证号码
    private String bankCardNo;//银行卡号
    private String bankName;//银行卡名称
    private String idPhoto;//身份证件照片
    private String bankCardPhoto;//银行照片
    private String shipPhoto;//船舶照片
    @AllowedNumber(values = {1, 2})
    private Integer from;//信息来源  1：后台新增  2:APP新增
    @AllowedNumber(values = {1, 2})
    private Integer status;//状态  1：启用  2：禁用
    private String description;//备注
    private String userName;//用户名
    private String nickName;//用户昵称

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Long getPreLoad() {
        return preLoad;
    }

    public void setPreLoad(Long preLoad) {
        this.preLoad = preLoad;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(String idPhoto) {
        this.idPhoto = idPhoto;
    }

    public String getBankCardPhoto() {
        return bankCardPhoto;
    }

    public void setBankCardPhoto(String bankCardPhoto) {
        this.bankCardPhoto = bankCardPhoto;
    }

    public String getShipPhoto() {
        return shipPhoto;
    }

    public void setShipPhoto(String shipPhoto) {
        this.shipPhoto = shipPhoto;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
