package com.xxx.boot.jdbc.mapper;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSession;

import com.xxx.boot.jdbc.registry.GlobalGroupRegistry;
import com.xxx.boot.jdbc.strategy.RobinLoaderStrategy;
import com.xxx.boot.jdbc.strategy.StrategyContext;
import com.xxx.boot.jdbc.strategy.WeightedRobinStrategy;
import com.xxx.boot.jdbc.support.Constant;
import com.xxx.boot.jdbc.support.SqlHelper;

/**
 * mapper action
 * Date: 2015-09-29
 *
 * @author luoxiaoyong
 *
 * @see org.apache.ibatis.binding.MapperMethod
 */
public class MobMapperMethod {
    private final MapperMethod.SqlCommand command;
    private final MapperMethod.MethodSignature method;
    private final Class<?> mapperInterface;


    public MobMapperMethod(Class<?> mapperInterface, Method method, Configuration config) {
        this.command = new MapperMethod.SqlCommand(config, mapperInterface, method);
        this.method = new MapperMethod.MethodSignature(config, method);
        this.mapperInterface = mapperInterface;
    }

    public Object execute(SqlSession sqlSession, Object[] args) {
        Object result;
        if (SqlCommandType.INSERT == command.getType()) {
            Object param = method.convertArgsToSqlCommandParam(args);
            result = rowCountResult(sqlSession.insert(command.getName(), param));
        } else if (SqlCommandType.UPDATE == command.getType()) {
            Object param = method.convertArgsToSqlCommandParam(args);
            result = rowCountResult(sqlSession.update(command.getName(), param));
        } else if (SqlCommandType.DELETE == command.getType()) {
            Object param = method.convertArgsToSqlCommandParam(args);
            result = rowCountResult(sqlSession.delete(command.getName(), param));
        } else if (SqlCommandType.SELECT == command.getType()) {
            Object param = method.convertArgsToSqlCommandParam(args);
            // 选择数据源，select默认到slave，如果sql中存在/* master */则选择master
            MappedStatement ms = sqlSession.getConfiguration().getMappedStatement(command.getName());
            List<SqlSession> slaves;
            SqlSession selectedSession = sqlSession;
            SqlSessionReference sqlSessionReference = MobSqlSessionRegistry.getInstance().get(mapperInterface);
            if(sqlSessionReference != null){
                slaves = sqlSessionReference.getSlaves();
                if(!SqlHelper.isHintMaster(ms.getBoundSql(wrapCollection(param)).getSql()) && !slaves.isEmpty()){
                    // 根据不同的策略选择slave
                    if(slaves.size() > 1){
                        StrategyContext<SqlSession> strategyContext;
                        if(Constant.LOAD_WEIGHT.equals(GlobalGroupRegistry.getInstance().getGroupDescription().getBalance())){
                            WeightedRobinStrategy<SqlSession> strategyw = new WeightedRobinStrategy<>(slaves, sqlSessionReference.getWeights());
                            strategyContext = new StrategyContext<>(strategyw);
                        } else {
                            // robin is default
                            RobinLoaderStrategy<SqlSession> strategyr = new RobinLoaderStrategy<>(slaves);
                            strategyContext = new StrategyContext<>(strategyr);
                        }
                        selectedSession = strategyContext.process() == null ? slaves.get(0) : strategyContext.process();
                    } else {
                        selectedSession = slaves.get(0);
                    }
                }
            }

            if (method.returnsVoid() && method.hasResultHandler()) {
                executeWithResultHandler(selectedSession, args);
                result = null;
            } else if (method.returnsMany()) {
                result = executeForMany(selectedSession, args);
            } else if (method.returnsMap()) {
                result = executeForMap(selectedSession, args);
            } else {

                result = selectedSession.selectOne(command.getName(), param);
            }
        } else {
            throw new BindingException("Unknown execution method for: " + command.getName());
        }
        if (result == null && method.getReturnType().isPrimitive() && !method.returnsVoid()) {
            throw new BindingException("Mapper method '" + command.getName()
                    + " attempted to return null from a method with a primitive return type (" + method.getReturnType() + ").");
        }
        return result;
    }

    private Object rowCountResult(int rowCount) {
        final Object result;
        if (method.returnsVoid()) {
            result = null;
        } else if (Integer.class.equals(method.getReturnType()) || Integer.TYPE.equals(method.getReturnType())) {
            result = rowCount;
        } else if (Long.class.equals(method.getReturnType()) || Long.TYPE.equals(method.getReturnType())) {
            result = (long) rowCount;
        } else if (Boolean.class.equals(method.getReturnType()) || Boolean.TYPE.equals(method.getReturnType())) {
            result = (rowCount > 0);
        } else {
            throw new BindingException("Mapper method '" + command.getName() + "' has an unsupported return type: " + method.getReturnType());
        }
        return result;
    }

    private void executeWithResultHandler(SqlSession sqlSession, Object[] args) {
        MappedStatement ms = sqlSession.getConfiguration().getMappedStatement(command.getName());
        if (void.class.equals(ms.getResultMaps().get(0).getType())) {
            throw new BindingException("method " + command.getName()
                    + " needs either a @ResultMap annotation, a @ResultType annotation,"
                    + " or a resultType attribute in XML so a ResultHandler can be used as a parameter.");
        }
        Object param = method.convertArgsToSqlCommandParam(args);
        if (method.hasRowBounds()) {
            RowBounds rowBounds = method.extractRowBounds(args);
            sqlSession.select(command.getName(), param, rowBounds, method.extractResultHandler(args));
        } else {
            sqlSession.select(command.getName(), param, method.extractResultHandler(args));
        }
    }

    private <E> Object executeForMany(SqlSession sqlSession, Object[] args) {
        List<E> result;
        Object param = method.convertArgsToSqlCommandParam(args);
        if (method.hasRowBounds()) {
            RowBounds rowBounds = method.extractRowBounds(args);
            result = sqlSession.<E>selectList(command.getName(), param, rowBounds);
        } else {
            result = sqlSession.<E>selectList(command.getName(), param);
        }
        // issue #510 Collections & arrays support
        if (!method.getReturnType().isAssignableFrom(result.getClass())) {
            if (method.getReturnType().isArray()) {
                return convertToArray(result);
            } else {
                return convertToDeclaredCollection(sqlSession.getConfiguration(), result);
            }
        }
        return result;
    }

    private <E> Object convertToDeclaredCollection(Configuration config, List<E> list) {
        Object collection = config.getObjectFactory().create(method.getReturnType());
        MetaObject metaObject = config.newMetaObject(collection);
        metaObject.addAll(list);
        return collection;
    }

    @SuppressWarnings("unchecked")
    private <E> E[] convertToArray(List<E> list) {
        E[] array = (E[]) Array.newInstance(method.getReturnType().getComponentType(), list.size());
        array = list.toArray(array);
        return array;
    }

    private <K, V> Map<K, V> executeForMap(SqlSession sqlSession, Object[] args) {
        Map<K, V> result;
        Object param = method.convertArgsToSqlCommandParam(args);
        if (method.hasRowBounds()) {
            RowBounds rowBounds = method.extractRowBounds(args);
            result = sqlSession.<K, V>selectMap(command.getName(), param, method.getMapKey(), rowBounds);
        } else {
            result = sqlSession.<K, V>selectMap(command.getName(), param, method.getMapKey());
        }
        return result;
    }

    private Object wrapCollection(final Object object) {
        if (object instanceof List) {
            DefaultSqlSession.StrictMap<Object> map = new DefaultSqlSession.StrictMap<Object>();
            map.put("list", object);
            return map;
        } else if (object != null && object.getClass().isArray()) {
            DefaultSqlSession.StrictMap<Object> map = new DefaultSqlSession.StrictMap<Object>();
            map.put("array", object);
            return map;
        }
        return object;
    }
}
