package com.szmtjk.authentication.service.wechat;

import com.szmtjk.business.bean.wechat.AppSecretConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by xiaohu on 2018/11/3.
 */
@Configuration
@ConfigurationProperties(prefix = "wechat")
public class WeChatAppSecretConfigs {
    private List<AppSecretConfig> appSecretConfigList;

    public List<AppSecretConfig> getAppSecretConfigList() {
        return appSecretConfigList;
    }

    public void setAppSecretConfigList(List<AppSecretConfig> appSecretConfigList) {
        this.appSecretConfigList = appSecretConfigList;
    }
}
