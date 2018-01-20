package com.xingyi.logistic.business.db.config;

import com.xxx.boot.jdbc.annotation.Dao;
import com.xxx.boot.jdbc.annotation.MobMapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jadic on 2017/12/31.
 */
@Configuration
@MobMapperScan(basePackages = {"com.xingyi.logistic.business.db.dao","com.xingyi.logistic.authentication.db.dao"}, annotationClass = Dao.class)
public class DBConfig {
}
