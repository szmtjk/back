package com.xingyi.logistic.qiangdan.bean;

import com.xingyi.logistic.business.bean.BaseModelAndDO;
import com.xingyi.logistic.common.annotation.NotNullEmpty;

public class BaseAppUser extends BaseModelAndDO {

    /**
     * 用户名
     */
    @NotNullEmpty
    private String userName;

    /**
     * 用户昵称
     */
    @NotNullEmpty
    private String nickName;

    /**
     * 用户密码
     */
    @NotNullEmpty
    private String userPass;

    /**
     * 临调船信息id
     */
    @NotNullEmpty
    private Integer shipInfoId;

    /**
     * 是否已删除
     */
    private Integer isDeleted;

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
