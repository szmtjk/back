package com.xingyi.logistic.business.model;

/**
 * Created by WCL on 2018/1/24.
 */
public class SendCmdSp {
    private int type;
    private int cmd;
    private int status;
    private String errorcode;
    private String stime;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCmd() {
        return cmd;
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    @Override
    public String toString() {
        return "SendCmdSp{" +
                "type=" + type +
                ", cmd=" + cmd +
                ", status=" + status +
                ", errorcode='" + errorcode + '\'' +
                ", stime='" + stime + '\'' +
                '}';
    }
}
