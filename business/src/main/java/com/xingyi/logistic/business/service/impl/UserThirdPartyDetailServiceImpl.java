package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.UserThirdPartyDetailDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.UserThirdPartyDetailDBQuery;
import com.xingyi.logistic.business.db.entity.UserThirdPartyDetailDO;
import com.xingyi.logistic.business.model.UserThirdPartyDetail;
import com.xingyi.logistic.business.model.UserThirdPartyDetailQuery;
import com.xingyi.logistic.business.service.UserThirdPartyDetailService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.UserThirdPartyDetailConverter;
import com.xingyi.logistic.business.service.converter.UserThirdPartyDetailQueryConverter;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class UserThirdPartyDetailServiceImpl extends BaseCRUDService<UserThirdPartyDetailDO, UserThirdPartyDetail, UserThirdPartyDetailDBQuery, UserThirdPartyDetailQuery> implements UserThirdPartyDetailService {

    private static final Logger LOG = LoggerFactory.getLogger(UserThirdPartyDetailServiceImpl.class);
    @Autowired
    private UserThirdPartyDetailDAO userThirdPartyDAO;

    @Autowired
    private UserThirdPartyDetailConverter userThirdPartyDetailConverter;

    @Autowired
    private UserThirdPartyDetailQueryConverter userThirdPartyDetailQueryConverter;

    @Override
    protected ModelConverter<UserThirdPartyDetailDO, UserThirdPartyDetail> getModelConverter() {
        return userThirdPartyDetailConverter;
    }

    @Override
    protected BaseDAO<UserThirdPartyDetailDO, UserThirdPartyDetailDBQuery> getDAO() {
        return userThirdPartyDAO;
    }

    @Override
    protected QueryConditionConverter<UserThirdPartyDetailQuery, UserThirdPartyDetailDBQuery> getConditionConverter() {
        return userThirdPartyDetailQueryConverter;
    }

    @Override
    public JsonRet<Integer> delByThirdId(String thirdId, int thirdType) {
        if (StringUtils.isEmpty(thirdId)) {
            return JsonRet.getErrRet(ErrCode.PARAM_INVALID);
        }
        try {
            int delCount = userThirdPartyDAO.delByThirdId(thirdId, thirdType);
            return JsonRet.getSuccessRet(delCount);
        } catch (Exception e) {
            LOG.error("del by thirdId err, thirdId:{}, thirdType:{}", thirdId, thirdType, e);
            return JsonRet.getErrRet(ErrCode.DEL_ERR);
        }
    }
}
