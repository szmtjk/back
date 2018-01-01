package com.xxx.boot.jdbc.mapper;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * mapper 实际执行类
 * Date: 2015-09-29
 *
 * @author luoxiaoyong
 */
public class MobMapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -6424540398559729338L;
    private final transient SqlSession sqlSession;
    private final Class<T> mapperInterface;
    private final transient Map<Method, MobMapperMethod> methodCache;

    public MobMapperProxy(SqlSession sqlSession, Class<T> mapperInterface, Map<Method, MobMapperMethod> methodCache) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
        this.methodCache = methodCache;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            try {
                return method.invoke(this, args);
            } catch (Exception t) {
                throw ExceptionUtil.unwrapThrowable(t);
            }
        }
        final MobMapperMethod mapperMethod = cachedMapperMethod(method);
        return mapperMethod.execute(sqlSession, args);
    }

    private MobMapperMethod cachedMapperMethod(Method method) {
        MobMapperMethod mapperMethod = methodCache.get(method);
        if (mapperMethod == null) {
            mapperMethod = new MobMapperMethod(mapperInterface, method, sqlSession.getConfiguration());
            methodCache.put(method, mapperMethod);
        }
        return mapperMethod;
    }
}
