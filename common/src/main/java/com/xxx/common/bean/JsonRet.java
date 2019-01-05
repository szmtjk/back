package com.xxx.common.bean;

/**
 * @author weifuping
 * @created 2016/7/29
 */
public class JsonRet<T> {

    private boolean success;
    private int errCode = 200;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setSuccessData(T data) {
        this.success = true;
        this.data = data;
    }

    public void setErrTip(int errCode, String msg) {
        this.success = false;
        this.errCode = errCode;
        this.msg = msg;
    }

    public void setErrTip(ErrCode errCode) {
        this.success = false;
        this.errCode = errCode.getCode();
        this.msg = errCode.getMsg();
    }

    public static <T> JsonRet<T> getSuccessRet(T data) {
        JsonRet<T> ret = new JsonRet<>();
        ret.setSuccessData(data);
        return ret;
    }

    public static <T> JsonRet<T> getErrRet(int errCode, String msg) {
        JsonRet<T> ret = new JsonRet<>();
        ret.setErrTip(errCode, msg);
        return ret;
    }

    public static <T> JsonRet<T> getErrRet(ErrCode errCode) {
        JsonRet<T> ret = new JsonRet<>();
        ret.setErrTip(errCode);
        return ret;
    }

}
