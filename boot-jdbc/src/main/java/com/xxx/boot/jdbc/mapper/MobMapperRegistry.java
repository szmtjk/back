package com.xxx.boot.jdbc.mapper;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.builder.annotation.MapperAnnotationBuilder;
import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;

/**
 * mapper注册器
 * Date: 2015-09-29
 *
 * @author luoxiaoyong
 */
public class MobMapperRegistry extends MapperRegistry {
    private Configuration mobConfig;
    private final Map<Class<?>, MobMapperProxyFactory<?>> mobKnownMappers = new HashMap<>();
    public MobMapperRegistry(Configuration config) {
        super(config);
        this.mobConfig = config;
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MobMapperProxyFactory<T> mapperProxyFactory = (MobMapperProxyFactory<T>) mobKnownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new BindingException("Type " + type + " is not known to the MobMapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new BindingException("Error getting mapper instance. Cause: " + e, e);
        }
    }

    public <T> boolean hasMapper(Class<T> type) {
        return mobKnownMappers.containsKey(type);
    }

    public <T> void addMapper(Class<T> type) {
        if (type.isInterface()) {
            if (hasMapper(type)) {
                throw new BindingException("Type " + type + " is already known to the MapperRegistry.");
            }
            boolean loadCompleted = false;
            try {
                mobKnownMappers.put(type, new MobMapperProxyFactory<T>(type));
                // It's important that the type is added before the parser is run
                // otherwise the binding may automatically be attempted by the
                // mapper parser. If the type is already known, it won't try.
                MapperAnnotationBuilder parser = new MapperAnnotationBuilder(mobConfig, type);
                parser.parse();
                loadCompleted = true;
            } finally {
                if (!loadCompleted) {
                    mobKnownMappers.remove(type);
                }
            }
        }
    }

    public Collection<Class<?>> getMappers() {
        return Collections.unmodifiableCollection(mobKnownMappers.keySet());
    }

    public void addMappers(String packageName, Class<?> superType) {
        ResolverUtil<Class<?>> resolverUtil = new ResolverUtil<Class<?>>();
        resolverUtil.find(new ResolverUtil.IsA(superType), packageName);
        Set<Class<? extends Class<?>>> mapperSet = resolverUtil.getClasses();
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }

    public void addMappers(String packageName) {
        addMappers(packageName, Object.class);
    }
}
