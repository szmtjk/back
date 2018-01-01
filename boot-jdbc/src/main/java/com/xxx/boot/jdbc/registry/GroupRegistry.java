package com.xxx.boot.jdbc.registry;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.xxx.boot.jdbc.datasource.IDatasourceGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Date: 2015-09-24
 *
 * @author luoxiaoyong
 */
public class GroupRegistry implements IGroupRegistry{

    private static final Logger LOG = LoggerFactory.getLogger(GroupRegistry.class);
    private final ConcurrentMap<String, IDatasourceGroup> registry = new ConcurrentHashMap<String, IDatasourceGroup>();
    private static final GroupRegistry INSTANCE = new GroupRegistry();

    private GroupRegistry() {
    }

    public static GroupRegistry getInstance(){
        return INSTANCE;
    }
    @Override
    public void registerGroup(IDatasourceGroup group) {
        IDatasourceGroup previous = registry.putIfAbsent(group.getId(), group);
        if(previous != null){
            LOG.info("Under this name a group was already registered: " + previous);
        }
    }

    @Override
    public void unregisterGroup(IDatasourceGroup group) {
        registry.remove(group.getId());
    }

    @Override
    public Collection<IDatasourceGroup> getDatasources() {
        return registry.values();
    }

    @Override
    public IDatasourceGroup getGroup(String groupId) {
        if (groupId == null) {
            throw new IllegalArgumentException("Null is not a valid groupId");
        }

        return registry.get(groupId);
    }
}
