package com.xxx.boot.jdbc.mapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.xxx.boot.jdbc.annotation.Dao;
import com.xxx.boot.jdbc.datasource.IDatasourceGroup;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

import com.xxx.boot.jdbc.datasource.DatasourceDescription;
import com.xxx.boot.jdbc.datasource.GroupDescription;
import com.xxx.boot.jdbc.datasource.SqlSessionGroup;
import com.xxx.boot.jdbc.exception.DatasourceWiredException;
import com.xxx.boot.jdbc.registry.GlobalGroupRegistry;
import com.xxx.boot.jdbc.registry.GroupRegistry;
import com.xxx.boot.jdbc.registry.SqlSessionRegistry;

import static org.springframework.util.Assert.notNull;

/**
 * BeanFactory用来注入MyBatis mapper interfaces，需要一个SqlSessionFactory or SqlSessionTemplate来构建
 * Date: 2015-09-25
 *
 * @author luoxiaoyong
 *
 * @see org.mybatis.spring.mapper.MapperFactoryBean
 */
public class MobMapperFactoryBean<T> extends SqlSessionDaoSupport implements FactoryBean<T>, ApplicationContextAware {
    private Class<T> mapperInterface;

    private boolean addToConfig = true;

    private String dataSourceRef;

    private SqlSessionFactory masterSqlSessionFactory;

    private SqlSessionReference sqlSessionReference = new SqlSessionReference();

    private ApplicationContext applicationContext;

    /**
     * Sets the mapper interface of the MyBatis mapper
     *
     * @param mapperInterface class of the interface
     */
    public void setMapperInterface(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * If addToConfig is false the mapper will not be added to MyBatis. This means
     * it must have been included in mybatis-config.xml.
     * <p>
     * If it is true, the mapper will be added to MyBatis in the case it is not already
     * registered.
     * <p>
     * By default addToCofig is true.
     *
     * @param addToConfig
     */
    public void setAddToConfig(boolean addToConfig) {
        this.addToConfig = addToConfig;
    }

    public void setDataSourceRef(String dataSourceRef) {
        this.dataSourceRef = dataSourceRef;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void checkDaoConfig() {

        if(masterSqlSessionFactory == null){
            // 检查mapper是否有Dao，存在的话，把值作为datasource;兼容以前的DAO，没有value继续处理
            String groupId = "";
            if(mapperInterface.isAnnotationPresent(Dao.class)){
                groupId = mapperInterface.getAnnotation(Dao.class).value();

                if(StringUtils.hasText(groupId)){
                    sqlFactoryInit(groupId);
                }
            }
            if(masterSqlSessionFactory == null) {
                if(StringUtils.hasText(dataSourceRef) ) {
                    // scan指定了datasource
                    groupId = dataSourceRef;
                    sqlFactoryInit(dataSourceRef);

                } else {
                    // 使用默认的datasource
                    GroupDescription groupDescription = GlobalGroupRegistry.getInstance().getGroupDescription();
                    groupId = groupDescription.getDefaultGroup();
                    if(StringUtils.hasText(groupId)){
                        sqlFactoryInit(groupId);
                    } else {
                        throw new IllegalArgumentException("default group value is empty.");
                    }
                }
            }
            sqlSessionReference.setGroupId(groupId);
        }

        notNull(this.mapperInterface, "Property 'mapperInterface' is required");

        // default to set master datasource
        if(getSqlSession() == null) {
            this.setSqlSessionFactory(masterSqlSessionFactory);
            // set up SqlSessionReference
            sqlSessionReference.setMaster(getSqlSession());
            MobSqlSessionRegistry.getInstance().putIfAbsent(this.mapperInterface, sqlSessionReference);
        }

        super.checkDaoConfig();

        Configuration configuration = getSqlSession().getConfiguration();
        // master config
        checkConfig(configuration);

        // slave config
        List<SqlSession> slaveSqlSessions = this.sqlSessionReference.getSlaves();
        if(!slaveSqlSessions.isEmpty()){
            for(SqlSession slaveSqlSession : slaveSqlSessions){
                checkConfig(slaveSqlSession.getConfiguration());
            }
        }
    }

    private void checkConfig(Configuration configuration){
        if (this.addToConfig && !configuration.hasMapper(this.mapperInterface)) {
            try {
                configuration.addMapper(this.mapperInterface);
            } catch (Exception t) {
                logger.error("Error while adding the mapper '" + this.mapperInterface + "' to configuration.", t);
                throw new IllegalArgumentException(t);
            } finally {
                ErrorContext.instance().reset();
            }
        }
    }

    @Override
    public T getObject() throws Exception {
        return getSqlSession().getMapper(this.mapperInterface);
    }

    @Override
    public Class<?> getObjectType() {
        return this.mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private void sqlFactoryInit(String groupId){
        IDatasourceGroup dsGroup = GroupRegistry.getInstance().getGroup(groupId);
        if(dsGroup == null || dsGroup.getMaster() == null) {
            throw new IllegalArgumentException("special data source group not exist.");
        }
        String locations = dsGroup.getMaster().getMapperLocations();
        // 装配主数据源
        buildSqlSession(groupId, dsGroup.getMaster(), locations, true);

        // 装配slave datasource
        for(DatasourceDescription slave : dsGroup.getSlaves()) {
            buildSqlSession(groupId, slave, slave.getMapperLocations(), false);
        }
    }

    private void setMappers(MobSqlSessionFactoryBean factoryBean, String locations){
        try {
            factoryBean.setMapperLocations(applicationContext.getResources(locations));
        } catch (IOException e) {
            throw new IllegalArgumentException("cannot load mapper from special location", e);
        }
    }

    private void buildSqlSession(String groupId, DatasourceDescription datasourceDescription, String locations, boolean isMater){
        SqlSessionGroup sqlSessionGroup = SqlSessionRegistry.getInstance().getGroup(groupId);
        if(sqlSessionGroup == null) {
            sqlSessionGroup = new SqlSessionGroup();
            sqlSessionGroup.setId(groupId);
            SqlSessionRegistry.getInstance().registerGroup(sqlSessionGroup);
        }

        try {
            if(isMater) {
                if(sqlSessionGroup.getMaster() == null){
                    MobSqlSessionFactoryBean factoryBean = new MobSqlSessionFactoryBean();
                    factoryBean.setDataSource(datasourceDescription);
                    setMappers(factoryBean, locations);
                    sqlSessionGroup.setMaster(factoryBean);
                }
                masterSqlSessionFactory = sqlSessionGroup.getMaster().getObject();
            } else {
                Map<String,MobSqlSessionFactoryBean> slaves = sqlSessionGroup.getSlaves();
                MobSqlSessionFactoryBean slave = slaves.get(datasourceDescription.getIdentity());
                if(slave == null){
                    slave= new MobSqlSessionFactoryBean();
                    slave.setDataSource(datasourceDescription);
                    setMappers(slave, locations);
                    sqlSessionGroup.addSlave(datasourceDescription.getIdentity(), slave);
                }

                sqlSessionReference.addSlave(new SqlSessionTemplate(slave.getObject()));
                sqlSessionReference.addWeight(datasourceDescription.getWeight());
            }

        } catch (Exception e) {
            throw new DatasourceWiredException("cannot wired data source when mapper initialized", e);
        }
    }
}
