package com.xingyi.logistic.qiangdan.bean;

import com.xingyi.logistic.business.bean.BaseModelAndDO;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

public class BaseAppUser extends BaseModelAndDO {

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户密码
     */
    private String userPass;

    /**
     * 临调船信息id
     */
    private Integer shipInfoId;

    /**
     * 是否已删除
     */
    private Integer isDeleted;

    private Integer sex;

    private String province;

    private String city;

    private String country;

    private String headImgUrl;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getShipInfoId() {
        return shipInfoId;
    }

    public void setShipInfoId(Integer shipInfoId) {
        this.shipInfoId = shipInfoId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
