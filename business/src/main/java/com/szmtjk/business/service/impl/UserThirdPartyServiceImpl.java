package com.szmtjk.business.service.impl;

import com.szmtjk.business.db.entity.UserThirdPartyDBQuery;
import com.szmtjk.business.db.entity.UserThirdPartyDO;
import com.szmtjk.business.model.UserThirdParty;
import com.szmtjk.business.model.UserThirdPartyQuery;
import com.szmtjk.business.service.UserThirdPartyService;
import com.szmtjk.business.service.base.BaseCRUDService;
import org.springframework.stereotype.Service;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class UserThirdPartyServiceImpl extends BaseCRUDService<UserThirdPartyDO, UserThirdParty, UserThirdPartyDBQuery, UserThirdPartyQuery> implements UserThirdPartyService {
}
