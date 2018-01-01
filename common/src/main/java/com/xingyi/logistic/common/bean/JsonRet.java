package com.xingyi.logistic.common.bean;

/**
 * @author weifuping
 * @created 2016/7/29
 */
public class JsonRet<T> {

    private boolean success;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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

    public void setErrTip(String msg) {
        this.success = false;
        this.msg = msg;
    }

    public static <T> JsonRet<T> getSuccessRet(T data) {
        JsonRet<T> ret = new JsonRet<>();
        ret.setSuccessData(data);
        return ret;
    }

    public static <T> JsonRet<T> getErrRet(String msg) {
        JsonRet<T> ret = new JsonRet<>();
        ret.setErrTip(msg);
        return ret;
    }
}
