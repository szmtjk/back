package com.xingyi.logistic.business.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.xingyi.logistic.business.db.dao.DispatchInfoDAO;
import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDO;
import com.xingyi.logistic.business.db.entity.DispatchInfoDBQuery;
import com.xingyi.logistic.business.db.entity.DispatchInfoDO;
import com.xingyi.logistic.business.db.entity.ShipWithStaffDO;
import com.xingyi.logistic.business.model.AvailableDispatchShip;
import com.xingyi.logistic.business.model.CustomerTaskFlow4DispatchQuery;
import com.xingyi.logistic.business.model.DispatchFlagInfo;
import com.xingyi.logistic.business.model.DispatchInfo;
import com.xingyi.logistic.business.model.DispatchInfoParam;
import com.xingyi.logistic.business.model.DispatchInfoQuery;
import com.xingyi.logistic.business.model.GetDispatchShipParam;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.DispatchInfoService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.CustomerTaskFlow4DispatchQueryConverter;
import com.xingyi.logistic.business.service.converter.DispatchInfoConverter;
import com.xingyi.logistic.business.service.converter.DispatchInfoQueryConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import com.xingyi.logistic.business.util.JsonUtil;
import com.xingyi.logistic.business.util.ParamValidator;
import com.xingyi.logistic.common.bean.ErrCode;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.common.bean.MiniUIJsonRet;
import com.xingyi.logistic.common.bean.QueryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class DispatchInfoServiceImpl extends BaseCRUDService<DispatchInfoDO, DispatchInfo, DispatchInfoDBQuery, DispatchInfoQuery> implements DispatchInfoService {

    private static final Logger LOG = LoggerFactory.getLogger(DispatchInfoServiceImpl.class);

    @Autowired
    private DispatchInfoDAO dispatchInfoDAO;

    @Autowired
    private ShipService shipService;

    @Autowired
    private ShipDAO shipDAO;

    @Autowired
    private DispatchInfoConverter dispatchInfoConverter;

    @Autowired
    private DispatchInfoQueryConverter dispatchInfoQueryConverter;

    @Autowired
    private ShipConverter shipConverter;

    @Autowired
    private ShipQueryConverter shipQueryConverter;

    @Autowired
    private CustomerTaskFlow4DispatchQueryConverter customerTaskFlow4DispatchQueryConverter;

    @Override
    public JsonRet<Object> getCustomerTaskFlows(CustomerTaskFlow4DispatchQuery query) {
        try {
            CustomerTaskFlow4DispatchDBQuery dbQuery = customerTaskFlow4DispatchQueryConverter.toDOCondition(query);
            int customerTaskFlow4DispatchCount = dispatchInfoDAO.getCustomerTaskFlow4DispatchCount(dbQuery);
            List<CustomerTaskFlow4DispatchDO> customerTaskFlow4DispatchList = null;
            if (customerTaskFlow4DispatchCount > 0) {
                customerTaskFlow4DispatchList = dispatchInfoDAO.getCustomerTaskFlow4DispatchList(dbQuery);
            }
            if (query != null && query.getQueryParamFlag() == QueryType.MINIUI.getCode()) {
                MiniUIJsonRet<Object> ret = new MiniUIJsonRet<>();
                ret.setSuccessData(customerTaskFlow4DispatchCount, customerTaskFlow4DispatchList);
                return ret;
            } else {
                Map<String, Object> params = new HashMap<>();
                params.put("total", customerTaskFlow4DispatchCount);
                params.put("list", customerTaskFlow4DispatchList);
                return JsonRet.getSuccessRet(params);
            }
        } catch (Exception e) {
            LOG.error("get customer task flows err, param:{}", JsonUtil.toJson(query), e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    @Override
    public JsonRet<List<AvailableDispatchShip>> getAvailableShips(GetDispatchShipParam param) {
        JsonRet<List<AvailableDispatchShip>> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, param)) {
            return ret;
        }
        ShipQuery shipQuery = new ShipQuery();
        shipQuery.setKey(param.getShipNo());
        if (!StringUtils.isEmpty(param.getShipType())) {
            shipQuery.setShipTypeList(new ArrayList<>());
            String[] shipTypes = param.getShipType().trim().split(",");
            for (String shipType : shipTypes) {
                try {
                    int type = Integer.parseInt(shipType);
                    if (type == 1 || type == 2 || type == 3) {
                        shipQuery.getShipTypeList().add(type);
                    }
                } catch(Exception e) {
                }
            }
        }
        try {
            List<ShipWithStaffDO> shipStaffS = shipDAO.queryWithStaff(shipQueryConverter.toDOCondition(shipQuery));
            List<AvailableDispatchShip> availableShipList = shipStaffS.stream().map(shipConverter::toDispatchShip).collect(Collectors.toList());
            ret.setSuccessData(availableShipList);
        } catch(Exception e) {
            ret.setErrTip(ErrCode.GET_ERR);
            LOG.error("get available ships err, param:{}", JsonUtil.toJson(param), e);
        }
        return ret;
    }

    @Override
    public JsonRet<Boolean> confirmDispatchInfoPlan(DispatchInfoParam dispatchInfoParam) {
        JsonRet<Boolean> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, dispatchInfoParam)) {
            return ret;
        }
        dispatchInfoParam.setPlanList(JsonUtil.toObject(dispatchInfoParam.getPlans(), new TypeReference<List<DispatchFlagInfo>>() {}));
        List<DispatchFlagInfo> updateList = dispatchInfoParam.getPlanList().stream().filter(o->o.getFlag() == 1).collect(Collectors.toList());
        List<DispatchFlagInfo> delList = dispatchInfoParam.getPlanList().stream().filter(o->o.getFlag() == 2).collect(Collectors.toList());
        List<DispatchFlagInfo> addList = dispatchInfoParam.getPlanList().stream().filter(o->o.getFlag() == 3).collect(Collectors.toList());
        try {
            updateList.forEach(o->{
                o.setCustomerTaskFlowId(dispatchInfoParam.getCustomerTaskFlowId());
                dispatchInfoDAO.update(dispatchInfoConverter.toDataObject(o));
            });

            delList.forEach(o->{
                o.setCustomerTaskFlowId(dispatchInfoParam.getCustomerTaskFlowId());
                dispatchInfoDAO.del(o.getId());
            });

            addList.forEach(o->{
                o.setCustomerTaskFlowId(dispatchInfoParam.getCustomerTaskFlowId());
                dispatchInfoDAO.insertSelective(dispatchInfoConverter.toDataObject(o));
            });

            dispatchInfoDAO.updateCustomerTaskStatus(dispatchInfoParam.getCustomerTaskFlowId());
            ret.setSuccessData(true);
        } catch (Exception e) {
            LOG.error("confirmDispatchInfoPlan err, param:{}", JsonUtil.toJson(dispatchInfoParam), e);
        }
        return ret;
    }

    @Override
    protected ModelConverter<DispatchInfoDO, DispatchInfo> getModelConverter() {
        return dispatchInfoConverter;
    }

    @Override
    protected BaseDAO<DispatchInfoDO, DispatchInfoDBQuery> getDAO() {
        return dispatchInfoDAO;
    }

    @Override
    protected QueryConditionConverter<DispatchInfoQuery, DispatchInfoDBQuery> getConditionConverter() {
        return dispatchInfoQueryConverter;
    }
}
