package com.szmtjk.business.service;

import com.szmtjk.business.model.UserThirdPartyDetail;
import com.szmtjk.business.model.UserThirdPartyDetailQuery;
import com.szmtjk.business.service.base.BaseService;
import com.xxx.common.bean.JsonRet;

/**
 * Created by xiaohu on 2018/11/2.
 */
public interface UserThirdPartyDetailService extends BaseService<UserThirdPartyDetail, UserThirdPartyDetailQuery> {

    JsonRet<Integer> delByThirdId(String thirdId, int thirdType);
}
