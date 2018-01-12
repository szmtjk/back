package com.xingyi.logistic.business.bean;

/**
 * 船舶人员
 */
public class BaseShipStaff extends BaseModelAndDO {

    private String name;//姓名
    private String mobile;//手机号
    private Integer gender;//性别 1：男  2：女
    private String identity;//身份证号
    private String birthday;//生日
    private String residence;//户籍
    private Integer shipId;//所属
    private Integer title;//岗位  1：船长  2：驾驶员  3：轮机员  4：水手
    private Integer isOwner;//是否承包人  1：是  2：否
    private Integer status;//状态  1：启用  2：禁用
    private String description;//备注

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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public Integer getTitle() {
        return title;
    }

    public void setTitle(Integer title) {
        this.title = title;
    }

    public Integer getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Integer isOwner) {
        this.isOwner = isOwner;
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
