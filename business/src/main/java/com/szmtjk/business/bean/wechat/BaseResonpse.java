package com.szmtjk.business.bean.wechat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by xiaohu on 2018/11/2.
 */
public class BaseResonpse {

    @JSONField(name = "errcode")
    private String errCode;
    @JSONField(name = "errmsg")
    private String errMsg;

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
