package com.xingyi.logistic.business.service;

import com.xingyi.logistic.business.model.UserThirdPartyDetail;
import com.xingyi.logistic.business.model.UserThirdPartyDetailQuery;
import com.xingyi.logistic.common.bean.JsonRet;

/**
 * Created by xiaohu on 2018/11/2.
 */
public interface UserThirdPartyDetailService extends BaseService<UserThirdPartyDetail, UserThirdPartyDetailQuery> {

    JsonRet<Integer> delByThirdId(String thirdId, int thirdType);
}
