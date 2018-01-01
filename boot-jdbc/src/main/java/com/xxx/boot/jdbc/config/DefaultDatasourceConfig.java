package com.xxx.boot.jdbc.config;

import com.xxx.boot.jdbc.common.BootConstant;
import com.xxx.boot.jdbc.datasource.GroupDescription;
import com.xxx.boot.jdbc.datasource.IDatasourceGroup;
import com.xxx.boot.jdbc.registry.GlobalGroupRegistry;
import com.xxx.boot.jdbc.registry.GroupRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * 配置默认的sql session
 * just for test
 * Date: 2015-09-29
 *
 * @author luoxiaoyong
 */
@Configuration
public class DefaultDatasourceConfig {

    @Bean
    public static ConfigLoader datasourceLoader() {
        ConfigLoader loader = new ConfigLoader();
        loader.setOrder(BootConstant.DATASOURCE_LOADER_ORDER);
        return loader;
    }

    @Bean
    public DataSource dataSource(){
        GroupDescription groupDescription = GlobalGroupRegistry.getInstance().getGroupDescription();
        if(groupDescription == null || StringUtils.isEmpty(groupDescription.getDefaultGroup())){
            throw new RuntimeException("required to special default data source group");
        }
        IDatasourceGroup datasourceGroup = GroupRegistry.getInstance().getGroup(groupDescription.getDefaultGroup());
        if(datasourceGroup == null || datasourceGroup.getMaster() == null) {
            throw new IllegalArgumentException("special data source group not exist.");
        }
        return datasourceGroup.getMaster();
    }
}
