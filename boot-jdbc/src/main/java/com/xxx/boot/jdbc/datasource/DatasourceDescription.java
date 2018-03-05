package com.xxx.boot.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * datasource bean
 * Date: 2015-09-24
 *
 * @author luoxiaoyong
 */
public class DatasourceDescription extends DruidDataSource {
    // 数据源标识
    private String identity;
    // 数据源所属组,一个组包含一个master,多个slave
    private String group;
    // 数据源角色，标识该数据源是master还是slave
    private String role;
    // 权重
    private int weight;

    private String mapperLocations;

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        String parent = super.toString();
        String last = parent.substring(parent.length()-1);
        buf.append(parent.substring(0, parent.length()-1));

        buf.append(",\n\tidentity:");
        buf.append(getIdentity());

        buf.append(",\n\tgroup:");
        buf.append(getGroup());

        buf.append(",\n\trole:");
        buf.append(getRole());
        buf.append(",\n\turl");
        buf.append(getUrl());
        buf.append(",\n\tmapperLocations:");
        buf.append(getMapperLocations());
        buf.append(",\n\tusername:");
        buf.append(getUsername());

        buf.append("\n"+last);

        return buf.toString();
    }
}
