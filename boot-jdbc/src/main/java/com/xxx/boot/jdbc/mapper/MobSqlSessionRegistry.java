package com.xxx.boot.jdbc.mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * sql session注册器
 * Date: 2015-09-28
 *
 * @author luoxiaoyong
 */
public class MobSqlSessionRegistry {
    private final Map<Class<?>, SqlSessionReference> knownSqlSessions = new HashMap<>();
    private static final MobSqlSessionRegistry INSTANCE = new MobSqlSessionRegistry();

    private MobSqlSessionRegistry() {

    }
    public static MobSqlSessionRegistry getInstance(){
        return INSTANCE;
    }

    /**
     * 返回成功添加的值
     * @param type
     * @param value
     * @return
     */
    public <T> SqlSessionReference putIfAbsent(Class<T> type, SqlSessionReference value){
        SqlSessionReference result = knownSqlSessions.putIfAbsent(type, value);
        if(result == null){
            result = knownSqlSessions.get(type);
        }
        return result;
    }

    public <T> SqlSessionReference get(Class<T> type){
        return knownSqlSessions.get(type);
    }
}
