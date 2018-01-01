package com.xxx.boot.jdbc.datasource;

import java.util.HashMap;
import java.util.Map;

import com.xxx.boot.jdbc.mapper.MobSqlSessionFactoryBean;

/**
 * 一组SqlSession factory bean，包含一组master/slave
 * Date: 2015-12-23
 *
 * @author luoxiaoyong
 */
public class SqlSessionGroup {
    // master
    private MobSqlSessionFactoryBean master;
    // slaves
    private Map<String,MobSqlSessionFactoryBean> slaves = new HashMap<>();

    private String id;

    public MobSqlSessionFactoryBean getMaster() {
        return master;
    }

    public void setMaster(MobSqlSessionFactoryBean master) {
        this.master = master;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String,MobSqlSessionFactoryBean> getSlaves() {
        return slaves;
    }

    public void addSlave(String id, MobSqlSessionFactoryBean slave){
        this.slaves.put(id, slave);
    }
}
