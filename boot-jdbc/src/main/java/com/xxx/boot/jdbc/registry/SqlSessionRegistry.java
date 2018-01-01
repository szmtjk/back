package com.xxx.boot.jdbc.registry;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.xxx.boot.jdbc.datasource.SqlSessionGroup;

/**
 * MobSqlSessionFactoryBean 注册
 * Date: 2015-12-23
 *
 * @author luoxiaoyong
 */
public class SqlSessionRegistry {
    private final ConcurrentMap<String, SqlSessionGroup> registry = new ConcurrentHashMap<>();
    private static final SqlSessionRegistry INSTANCE = new SqlSessionRegistry();

    private SqlSessionRegistry() {
    }
    public static SqlSessionRegistry getInstance(){
        return INSTANCE;
    }

    public void registerGroup(SqlSessionGroup group){
        registry.putIfAbsent(group.getId(), group);
    }

    public void unregisterGroup(SqlSessionGroup group){
        registry.remove(group.getId());
    }

    public Collection<SqlSessionGroup> getDatasources() {
        return registry.values();
    }

    public SqlSessionGroup getGroup(String groupId) {
        if (groupId == null) {
            throw new IllegalArgumentException("Null is not a valid groupId");
        }

        return registry.get(groupId);
    }
}
