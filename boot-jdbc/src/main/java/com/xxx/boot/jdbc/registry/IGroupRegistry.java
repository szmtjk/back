package com.xxx.boot.jdbc.registry;

import java.util.Collection;

import com.xxx.boot.jdbc.datasource.IDatasourceGroup;

/**
 * Data source group 注册接口
 * Date: 2015-09-24
 *
 * @author luoxiaoyong
 */
public interface IGroupRegistry {
    /**
     * datasource group 注册
     * @param group
     */
    void registerGroup(IDatasourceGroup group);

    /**
     * 取消注册指定的datasource group
     * @param group
     */
    void unregisterGroup(IDatasourceGroup group);

    /**
     * 返回注册过的data source
     * @return
     */
    Collection<IDatasourceGroup> getDatasources();

    /**
     * 返回指定的group
     * @param groupId
     * @return
     */
    IDatasourceGroup getGroup(String groupId);
}
