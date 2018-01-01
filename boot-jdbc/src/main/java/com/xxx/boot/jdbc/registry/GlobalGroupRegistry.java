package com.xxx.boot.jdbc.registry;


import com.xxx.boot.jdbc.datasource.GroupDescription;

/**
 * Date: 2015-09-28
 *
 * @author luoxiaoyong
 */
public class GlobalGroupRegistry {
    private static final GlobalGroupRegistry INSTANCE = new GlobalGroupRegistry();
    private final GroupDescription groupDescription;
    private GlobalGroupRegistry(){
        groupDescription = new GroupDescription();
    }

    public static GlobalGroupRegistry getInstance(){
        return INSTANCE;
    }

    public GroupDescription getGroupDescription(){
        return groupDescription;
    }
}
