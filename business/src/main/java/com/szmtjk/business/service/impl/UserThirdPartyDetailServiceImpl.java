package com.szmtjk.business.service.impl;

import com.szmtjk.business.model.UserThirdPartyDetailQuery;
import com.szmtjk.business.service.UserThirdPartyDetailService;
import com.szmtjk.business.service.converter.UserThirdPartyDetailConverter;
import com.szmtjk.business.db.dao.UserThirdPartyDetailDAO;
import com.szmtjk.business.db.dao.base.BaseDAO;
import com.szmtjk.business.db.entity.UserThirdPartyDetailDBQuery;
import com.szmtjk.business.db.entity.UserThirdPartyDetailDO;
import com.szmtjk.business.model.UserThirdPartyDetail;
import com.szmtjk.business.service.base.BaseCRUDService;
import com.szmtjk.business.converter.base.ModelConverter;
import com.szmtjk.business.converter.base.QueryConditionConverter;
import com.szmtjk.business.service.converter.UserThirdPartyDetailQueryConverter;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
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
