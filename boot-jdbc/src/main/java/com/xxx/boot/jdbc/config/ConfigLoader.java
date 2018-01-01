package com.xxx.boot.jdbc.config;

import com.xxx.boot.jdbc.datasource.DatasourceDescription;
import com.xxx.boot.jdbc.datasource.DatasourceGroup;
import com.xxx.boot.jdbc.datasource.GroupDescription;
import com.xxx.boot.jdbc.datasource.IDatasourceGroup;
import com.xxx.boot.jdbc.exception.DatasourceParserException;
import com.xxx.boot.jdbc.registry.GlobalGroupRegistry;
import com.xxx.boot.jdbc.registry.GroupRegistry;
import com.xxx.boot.jdbc.support.Constant;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Date: 2015-09-23
 *
 * @author luoxiaoyong
 */
public class ConfigLoader implements BeanFactoryPostProcessor, PriorityOrdered, EnvironmentAware {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigLoader.class);
    private int order = Ordered.LOWEST_PRECEDENCE;  // default: same as non-Ordered
    Environment environment;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        LOG.info("mob boot start to load datasource");
        // load config and construct data source
        Map<String, Object> prop = getAllProperties((ConfigurableEnvironment)environment);
        Map<String, DatasourceDescription> datasources = new HashMap<>();
        GroupDescription groupDescription = GlobalGroupRegistry.getInstance().getGroupDescription();

        for(Map.Entry<String, Object> entry : prop.entrySet()){
            String key = entry.getKey();
            int position = key.lastIndexOf(".");
            if ( key.startsWith(Constant.DARASOURCE_PRFIX) ) {
                // 配置 datasource
                DatasourceDescription ds = datasources.putIfAbsent(key.substring(0, position), new DatasourceDescription());
                if(ds == null){
                    ds = datasources.get(key.substring(0, position));
                }

                try {
                    String subKey = key.substring(position + 1);
                    // tomcat 配置属性无法获取，直接使用env
                    if("url".equals(subKey)){
                        ds.setUrl(environment.getProperty(key));
                    } else if("username".equals(subKey)){
                        ds.setUsername(environment.getProperty(key));
                    } else if("password".equals(subKey)) {
                        ds.setPassword(environment.getProperty(key));
                    } else if("maxActive".equals(subKey)){
                        ds.setMaxActive(Integer.valueOf(environment.getProperty(key)));
                    } else if("driverClassName".equals(subKey)){
                        ds.setDriverClassName(environment.getProperty(key));
                    } else if("connectionInitSqls".equals(subKey)){
                        String itemValue = environment.getProperty(key);
                        if(!StringUtils.isEmpty(itemValue)) {
                            ds.setConnectionInitSqls(Arrays.asList(itemValue.split(",")));
                        }
                    } else {
                        BeanUtils.setProperty(ds, subKey, entry.getValue());
                    }
                } catch (Exception e) {
                    throw new DatasourceParserException("construct data source fail", e);
                }
            } else if(key.startsWith(Constant.GROUP_PRFIX)){
                // 配置group控制属性
                try {
                    BeanUtils.setProperty(groupDescription, key.substring(position + 1), entry.getValue());
                } catch (Exception e) {
                    throw new DatasourceParserException("construct data source group description fail", e);
                }
            }
        }
        LOG.info("group description is {}", groupDescription);
        LOG.info("all config datasource is {}", datasources.toString());
        // register data source group
        for(DatasourceDescription ddc : datasources.values()){
            String groupId = ddc.getGroup();
            if(StringUtils.isEmpty(groupId)){
                throw new DatasourceParserException("require group name missing");
            }
            IDatasourceGroup dsGroup = GroupRegistry.getInstance().getGroup(groupId);
            if(dsGroup == null){
                dsGroup = new DatasourceGroup();
            }
            dsGroup.setId(groupId);
            if (Constant.ROLE_MASTER.equals(ddc.getRole())) {
                if (dsGroup.getMaster() != null) {
                    throw new DatasourceParserException("data source group " + groupId + " already have a master "
                            + ((DatasourceDescription) dsGroup.getMaster()).getIdentity() + " , new master " + ddc.getIdentity() + " not allowed");
                }

                dsGroup.setMaster(ddc);
            } else if(Constant.ROLE_SLAVE.equals(ddc.getRole())){
                dsGroup.addSlave(ddc);
            } else if(StringUtils.isEmpty(ddc.getRole())){
                // back compatibility
                dsGroup.setMaster(ddc);
            } else {
                throw new DatasourceParserException("no data source role support");
            }

            GroupRegistry.getInstance().registerGroup(dsGroup);
        }
    }

    /**
     * Set the order value of this object for sorting purposes.
     * @see PriorityOrdered
     */
    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    private Map<String,Object> getAllProperties(ConfigurableEnvironment aEnv) {
        Map<String,Object> result = new HashMap<>();

        Iterator<PropertySource<?>> it = aEnv.getPropertySources().iterator();
        while(it.hasNext()){
            PropertySource<?> ps = it.next();
            //MapPropertySource
            if (ps instanceof MapPropertySource) {
                result.putAll(((MapPropertySource) ps).getSource());
            }
        }

        return result;
    }
}
