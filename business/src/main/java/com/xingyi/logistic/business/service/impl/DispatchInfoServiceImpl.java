package com.xingyi.logistic.business.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.xingyi.logistic.business.db.dao.DispatchInfoDAO;
import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerTaskFlow4DispatchDO;
import com.xingyi.logistic.business.db.entity.DispatchInfoDBQuery;
import com.xingyi.logistic.business.db.entity.DispatchInfoDO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipWithStaffDO;
import com.xingyi.logistic.business.model.AvailableDispatchShip;
import com.xingyi.logistic.business.model.CustomerTaskFlow4Dispatch;
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
import com.xingyi.logistic.business.service.converter.CustomerTaskFlow4DispatchConverter;
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
import org.springframework.beans.BeanUtils;
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
    private CustomerTaskFlow4DispatchConverter customerTaskFlow4DispatchConverter;

    @Autowired
    private CustomerTaskFlow4DispatchQueryConverter customerTaskFlow4DispatchQueryConverter;

    @Override
    public JsonRet<Object> getCustomerTaskFlows(CustomerTaskFlow4DispatchQuery query) {
        try {
            CustomerTaskFlow4DispatchDBQuery dbQuery = customerTaskFlow4DispatchQueryConverter.toDOCondition(query);

            int customerTaskFlow4DispatchCount = dispatchInfoDAO.getCustomerTaskFlow4DispatchCount(dbQuery);

            List<CustomerTaskFlow4Dispatch> pageList = null;
            if (customerTaskFlow4DispatchCount > 0) {
                List<CustomerTaskFlow4DispatchDO> customerTaskFlow4DispatchList = dispatchInfoDAO.getCustomerTaskFlow4DispatchList(dbQuery);
                pageList = customerTaskFlow4DispatchList.stream().map(customerTaskFlow4DispatchConverter::toModel).collect(Collectors.toList());
            }

            if (query != null && query.getQueryParamFlag() == QueryType.MINIUI.getCode()) {
                MiniUIJsonRet<Object> ret = new MiniUIJsonRet<>();
                ret.setSuccessData(customerTaskFlow4DispatchCount, pageList);
                return ret;
            } else {
                Map<String, Object> params = new HashMap<>();
                params.put("total", customerTaskFlow4DispatchCount);
                params.put("list",  pageList);
                return JsonRet.getSuccessRet(params);
            }
        } catch (Exception e) {
            LOG.error("get customer task flows err, param:{}", JsonUtil.toJson(query), e);
            return JsonRet.getErrRet(ErrCode.GET_ERR);
        }
    }

    @Override
    public JsonRet<Object> getAvailableShips(GetDispatchShipParam param) {
        JsonRet<Object> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, param)) {
            return ret;
        }
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);
        shipQuery.setCustomerTaskFlowId(param.getCustomerTaskFlowId());
        shipQuery.setKey(param.getShipNo());
        if (!StringUtils.isEmpty(param.getShipFlag())) {
            shipQuery.setShipFlags(new ArrayList<>());
            String[] shipFlags = param.getShipFlag().trim().split(",");
            for (String shipFlag : shipFlags) {
                try {
                    int type = Integer.parseInt(shipFlag);
                    if (type == 1 || type == 2 || type == 3) {
                        shipQuery.getShipFlags().add(type);
                    }
                } catch(Exception e) {
                    LOG.error("parse ship flag err, shipFlag:{}", param.getShipFlag(), e);
                }
            }
        }
        try {
            ShipDBQuery shipDBQuery = shipQueryConverter.toDOCondition(shipQuery);
            int total = shipDAO.queryWithStaffCount(shipDBQuery);
            List<AvailableDispatchShip> availableShipList = null;
            if (total > 0) {
                List<ShipWithStaffDO> shipStaffS = shipDAO.queryWithStaffList(shipDBQuery);
                availableShipList = shipStaffS.stream().map(shipConverter::toDispatchShip).collect(Collectors.toList());
            }

            if (shipQuery.getQueryParamFlag() == QueryType.MINIUI.getCode()) {
                MiniUIJsonRet<Object> miniUIJsonRet = new MiniUIJsonRet<>();
                miniUIJsonRet.setSuccessData(total, availableShipList);
                return miniUIJsonRet;
            } else {
                Map<String, Object> params = new HashMap<>();
                params.put("total", total);
                params.put("list",  availableShipList);
                return JsonRet.getSuccessRet(params);
            }
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
                if (o.getStashStatus() == 1) {//暂存状态
                    o.setStatus(-1);
                }
                o.setCustomerTaskFlowId(dispatchInfoParam.getCustomerTaskFlowId());
                dispatchInfoDAO.update(dispatchInfoConverter.toDataObject(o));
            });

            delList.forEach(o->{
                o.setCustomerTaskFlowId(dispatchInfoParam.getCustomerTaskFlowId());
                dispatchInfoDAO.del(o.getId());
            });

            addList.forEach(o->{
                if (o.getStashStatus() == 1) {//暂存状态
                    o.setStatus(-1);
                }
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
