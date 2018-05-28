package com.xingyi.logistic.business.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by WCL on 2018/1/12.
 */

@XmlRootElement(name="dispatchplan")
public class DispatchPlan {
    private long dispatchplansendid;
    private String taskname;
    private String devicecode;
    private String linecode;
    private String linename;
    private String planruntime;
    private String startfieldcode;
    private String startfieldname;
    private String endfieldcode;
    private String endfieldname;
    private String servertime;
    private String startplanarrivetime;
    private String planarrivetime;
    private String goodstype;
    private String goodsname;
    private String planton;
    private String realton;

    public long getDispatchplansendid() {
        return dispatchplansendid;
    }

    public void setDispatchplansendid(long dispatchplansendid) {
        this.dispatchplansendid = dispatchplansendid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getDevicecode() {
        return devicecode;
    }

    public void setDevicecode(String devicecode) {
        this.devicecode = devicecode;
    }

    public String getLinecode() {
        return linecode;
    }

    public void setLinecode(String linecode) {
        this.linecode = linecode;
    }

    public String getLinename() {
        return linename;
    }

    public void setLinename(String linename) {
        this.linename = linename;
    }

    public String getPlanruntime() {
        return planruntime;
    }

    public void setPlanruntime(String planruntime) {
        this.planruntime = planruntime;
    }

    public String getStartfieldcode() {
        return startfieldcode;
    }

    public void setStartfieldcode(String startfieldcode) {
        this.startfieldcode = startfieldcode;
    }

    public String getStartfieldname() {
        return startfieldname;
    }

    public void setStartfieldname(String startfieldname) {
        this.startfieldname = startfieldname;
    }

    public String getEndfieldcode() {
        return endfieldcode;
    }

    public void setEndfieldcode(String endfieldcode) {
        this.endfieldcode = endfieldcode;
    }

    public String getEndfieldname() {
        return endfieldname;
    }

    public void setEndfieldname(String endfieldname) {
        this.endfieldname = endfieldname;
    }

    public String getServertime() {
        return servertime;
    }

    public void setServertime(String servertime) {
        this.servertime = servertime;
    }

    public String getStartplanarrivetime() {
        return startplanarrivetime;
    }

    public void setStartplanarrivetime(String startplanarrivetime) {
        this.startplanarrivetime = startplanarrivetime;
    }

    public String getPlanarrivetime() {
        return planarrivetime;
    }

    public void setPlanarrivetime(String planarrivetime) {
        this.planarrivetime = planarrivetime;
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public String getPlanton() {
        return planton;
    }

    public void setPlanton(String planton) {
        this.planton = planton;
    }

    public String getRealton() {
        return realton;
    }

    public void setRealton(String realton) {
        this.realton = realton;
    }
}
