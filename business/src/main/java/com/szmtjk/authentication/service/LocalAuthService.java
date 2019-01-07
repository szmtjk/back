package com.szmtjk.authentication.service;

import com.szmtjk.authentication.model.LocalAuth;
import com.szmtjk.business.service.base.BaseService;
import com.szmtjk.authentication.model.LocalAuthQuery;

public interface LocalAuthService extends BaseService<LocalAuth,LocalAuthQuery> {
    /**
     * 查询指定用户本地账号信息
     * @param userId
     * @return
     */
    LocalAuth queryByUserId(Long userId);

    LocalAuth queryByUserName(String userName);
}
