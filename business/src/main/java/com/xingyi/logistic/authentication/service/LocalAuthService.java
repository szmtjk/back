package com.xingyi.logistic.authentication.service;

import com.xingyi.logistic.authentication.model.LocalAuth;
import com.xingyi.logistic.authentication.model.LocalAuthQuery;
import com.xingyi.logistic.business.service.BaseService;

public interface LocalAuthService extends BaseService<LocalAuth,LocalAuthQuery> {
    /**
     * 查询指定用户本地账号信息
     * @param userId
     * @return
     */
    LocalAuth queryByUserId(Long userId);
}
