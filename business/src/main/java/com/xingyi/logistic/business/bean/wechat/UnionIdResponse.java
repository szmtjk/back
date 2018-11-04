package com.xingyi.logistic.business.bean.wechat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by xiaohu on 2018/10/26.
 */
public class UnionIdResponse extends BaseResonpse {

    @JSONField(name = "openid")
    private String openId;
    @JSONField(name = "nickname")
    private String nickName;
    private int sex;
    private String city;
    private String province;
    private String country;
    @JSONField(name = "headimgurl")
    private String headimgurl;
    @JSONField(name = "unionid")
    private String unionId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }
}
