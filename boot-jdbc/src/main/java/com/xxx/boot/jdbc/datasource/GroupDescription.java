package com.xxx.boot.jdbc.datasource;

import com.xxx.boot.jdbc.support.Constant;

/**
 * 定义data source group全局参数
 * Date: 2015-09-28
 *
 * @author luoxiaoyong
 */
public class GroupDescription {
    // slave 负载策略
    private String balance = Constant.LOAD_ROBIN;

    // 默认data source
    private String defaultGroup;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(String defaultGroup) {
        this.defaultGroup = defaultGroup;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("{");
        buf.append("\n\tdefaultDs:");
        buf.append(getDefaultGroup());
        buf.append(",\n\tbalance:");
        buf.append(getBalance());

        return buf.toString();
    }
}
