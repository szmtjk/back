package com.xxx.common.bean;

/**
 * Created by Jadic on 2018/1/8.
 */
public class MiniUIJsonRet <T> extends JsonRet<T> {

    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setSuccessData(int total, T data) {
        this.setSuccess(true);
        this.setTotal(total);
        this.setData(data);
    }
}
