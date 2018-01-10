package com.xingyi.logistic.business.bean;

import com.xingyi.logistic.common.annotation.AllowedNumber;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

import javax.validation.constraints.NotNull;

/**
 * 客户信息
 */
public class BaseCustomer extends BaseModelAndDO {

    @NotNullEmpty
    private String customerNo; //客户单位编号

    @NotNullEmpty
    private String fullName;//客户单位名称

    @NotNullEmpty
    private String simpleName;//单位简称

    @NotNullEmpty
    private String contact;//单位联系人

    @NotNullEmpty
    private String phone;//单位电话

    @NotNullEmpty
    private String email;//邮箱

    @AllowedNumber(values = {1, 2})
    private Integer type;//客户类型  1：长期  2：临时

    private Integer goodsType;//货物分类  按位标识是否支持该类型，2字节存储  从第0位到8位使用，高位缺省，0位:熟料  1位:电煤  2位：集装箱  3~7位保留填0，8位：其他  0：未选中  1：选中

    @NotNullEmpty
    private String contact1;

    @NotNullEmpty
    private String title1;

    @NotNullEmpty
    private String phone1;

    @NotNullEmpty
    private String weChat1;

    @NotNullEmpty
    private String qq1;
    @NotNullEmpty
    private String email1;
    @NotNullEmpty
    private String contact2;
    @NotNullEmpty
    private String title2;
    @NotNullEmpty
    private String phone2;
    @NotNullEmpty
    private String weChat2;
    @NotNullEmpty
    private String qq2;
    @NotNullEmpty
    private String email2;
    @NotNullEmpty
    private String contact3;
    @NotNullEmpty
    private String title3;
    @NotNullEmpty
    private String phone3;
    @NotNullEmpty
    private String weChat3;
    @NotNullEmpty
    private String qq3;
    @NotNullEmpty
    private String email3;
    @NotNullEmpty
    private String description;

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getWeChat1() {
        return weChat1;
    }

    public void setWeChat1(String weChat1) {
        this.weChat1 = weChat1;
    }

    public String getQq1() {
        return qq1;
    }

    public void setQq1(String qq1) {
        this.qq1 = qq1;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getWeChat2() {
        return weChat2;
    }

    public void setWeChat2(String weChat2) {
        this.weChat2 = weChat2;
    }

    public String getQq2() {
        return qq2;
    }

    public void setQq2(String qq2) {
        this.qq2 = qq2;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getContact3() {
        return contact3;
    }

    public void setContact3(String contact3) {
        this.contact3 = contact3;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getWeChat3() {
        return weChat3;
    }

    public void setWeChat3(String weChat3) {
        this.weChat3 = weChat3;
    }

    public String getQq3() {
        return qq3;
    }

    public void setQq3(String qq3) {
        this.qq3 = qq3;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
