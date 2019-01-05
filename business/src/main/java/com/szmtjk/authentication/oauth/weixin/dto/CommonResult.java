package com.szmtjk.authentication.oauth.weixin.dto;

/**
 * @author 16101934
 * @time 2018/1/27 18:17
 */
public class CommonResult {
    protected Integer errcode;
    protected String errmsg;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isSuccess(){
        return null == this.errcode || 0 == this.errcode;
    }
}
