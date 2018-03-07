package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.SailingInfoDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.SailingInfoDBQuery;
import com.xingyi.logistic.business.db.entity.SailingInfoDO;
import com.xingyi.logistic.business.model.SailingInfo;
import com.xingyi.logistic.business.model.SailingInfoQuery;
import com.xingyi.logistic.business.service.SailingInfoService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.SailingInfoConverter;
import com.xingyi.logistic.business.service.converter.SailingInfoQueryConverter;
import com.xingyi.logistic.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 航次信息
 */
@Service
public class SailingInfoImpl extends BaseCRUDService<SailingInfoDO, SailingInfo, SailingInfoDBQuery, SailingInfoQuery> implements SailingInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(SailingInfoImpl.class);

    @Autowired
    private SailingInfoDAO sailingInfoDAO;

    @Autowired
    private SailingInfoConverter sailingInfoConverter;

    @Autowired
    private SailingInfoQueryConverter sailingInfoQueryConverter;

    @Autowired
    private TaskStatusService taskStatusService;

    @Override
    protected boolean isBizOperationAfterAddPassed(JsonRet<?> ret, SailingInfo sailingInfo, SailingInfoDO dataObj) {
        taskStatusService.updateDispatchStatus(sailingInfo.getOrderId(), sailingInfo.getStatus());
        return true;
    }

    @Override
    protected boolean isBizOperationAfterModifyPassed(JsonRet<?> ret, SailingInfo sailingInfo, SailingInfoDO dataObj) {
        taskStatusService.updateDispatchStatus(sailingInfo.getOrderId(), sailingInfo.getStatus());
        return true;
    }

    /**
     * 加载调度的船
     * @param map
     * @return
     */
    public List<Map<String, Object>> queryDispatchShipInfo(Map<String, String> map)
    {
        return sailingInfoDAO.queryDispatchShipInfo(map);
    }

    /**
     * 加载未处理的所有调度计划
     * @param map
     * @return
     */
    public List<Map<String, Object>> queryUnDealDispatchShipInfo(Map<String, String> map)
    {
        return sailingInfoDAO.queryUnDealDispatchShipInfo(map);
    }



    @Override
    protected ModelConverter<SailingInfoDO, SailingInfo> getModelConverter() {
        return sailingInfoConverter;
    }

    @Override
    protected BaseDAO<SailingInfoDO, SailingInfoDBQuery> getDAO() {
        return sailingInfoDAO;
    }

    @Override
    protected QueryConditionConverter<SailingInfoQuery, SailingInfoDBQuery> getConditionConverter() {
        return sailingInfoQueryConverter;
    }
}
