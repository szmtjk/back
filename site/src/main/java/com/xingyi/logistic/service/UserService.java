package com.xingyi.logistic.service;

import com.xingyi.logistic.util.HttpUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weifuping
 * @created 2016/8/18
 */
@Service
@ConfigurationProperties(prefix = "tempUser")
public class UserService {

    private List<String> userNamePass = new ArrayList<>();
    private Map<String, String> userMap;

    @PostConstruct
    protected void init() {
        userMap = new HashMap();
        if (!CollectionUtils.isEmpty(userNamePass)) {
            for (String userNamePas : userNamePass) {
                if (!StringUtils.isEmpty(userNamePas)) {
                    String[] userInfo = userNamePas.split("@");
                    if (userInfo.length == 2 && !StringUtils.isEmpty(userInfo[0]) && !StringUtils.isEmpty(userInfo[1])) {
                        userMap.put(userInfo[0], userInfo[1]);
                    }
                }
            }
        }
    }

    public boolean isUserInfoValid(String userName, String userPass) {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(userPass)) {
            if (isUserNamePassValid(userName, userPass)) {
                HttpUtil.addLoginUser(userName);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private boolean isUserNamePassValid(String userName, String userPass) {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(userPass)) {
            return userPass.equals(userMap.get(userName));
        }
        return false;
    }

    public List<String> getUserNamePass() {
        return userNamePass;
    }

    public void setUserNamePass(List<String> userNamePass) {
        this.userNamePass = userNamePass;
    }
}
