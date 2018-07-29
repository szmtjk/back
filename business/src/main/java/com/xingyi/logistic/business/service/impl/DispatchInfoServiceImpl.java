package com.xingyi.logistic.business.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.xingyi.logistic.business.db.dao.DispatchInfoDAO;
import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.*;
import com.xingyi.logistic.business.model.*;
import com.xingyi.logistic.business.mq.SendMessageServer;
import com.xingyi.logistic.business.service.CustomerTaskFlowService;
import com.xingyi.logistic.business.service.DispatchInfoService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.*;
import com.xingyi.logistic.business.util.DateUtils;
import com.xingyi.logistic.business.util.JsonUtil;
import com.xingyi.logistic.business.util.ParamValidator;
import com.xingyi.logistic.business.util.PrimitiveUtil;
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

import java.text.SimpleDateFormat;
import java.util.*;
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

    @Autowired
    private CustomerTaskFlowService customerTaskFlowService;

    @Autowired
    private TaskStatusService taskStatusService;

    @Autowired
    private SendMessageServer sendMessageServer;

    /**
     * 加载所有设备
     * @return
     */
    public List<Map<String,Object>> getDispatchInfoInfo(ReportParam param)
    {
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        DispatchInfoQuery dispatchInfoQuery = new DispatchInfoQuery();
        BeanUtils.copyProperties(param, dispatchInfoQuery);
        try {
            DispatchInfoDBQuery dispatchInfoDBQuery = dispatchInfoQueryConverter.toDOCondition(dispatchInfoQuery);
            list = dispatchInfoDAO.getDispatchInfoInfo(dispatchInfoDBQuery);
        } catch(Exception e) {

            LOG.error("query getDispatchInfoInfo err, param:{}", JsonUtil.toJson(param), e);
        }
        return list;
    }

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
    public JsonRet<Object> getPoundBalanceList(ReportParam param) {
        JsonRet<Object> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, param)) {
            return ret;
        }
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);

        try {
            ShipDBQuery shipDBQuery = shipQueryConverter.toDOCondition(shipQuery);
            int total = shipDAO.queryReportOneCount(shipDBQuery);
            List<Map<String,Object>> shipStaffS = null;
            if (total > 0) {
                 shipStaffS = shipDAO.queryReportOneList(shipDBQuery);
            }
            MiniUIJsonRet<Object> miniUIJsonRet = new MiniUIJsonRet<>();
            miniUIJsonRet.setSuccessData(total, shipStaffS);
            return miniUIJsonRet;

        } catch(Exception e) {
            ret.setErrTip(ErrCode.GET_ERR);
            LOG.error("query report one err, param:{}", JsonUtil.toJson(param), e);
        }
        return ret;
    }

    @Override
    public JsonRet<Object> getReportFiveList(ReportParam param) {
        JsonRet<Object> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, param)) {
            return ret;
        }
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);

        try {
            ShipDBQuery shipDBQuery = shipQueryConverter.toDOCondition(shipQuery);
            int total = shipDAO.queryReportFiveCount(shipDBQuery);
            List<Map<String,Object>> shipStaffS = null;
            if (total > 0) {
                shipStaffS = shipDAO.queryReportFiveList(shipDBQuery);
            }
            MiniUIJsonRet<Object> miniUIJsonRet = new MiniUIJsonRet<>();
            miniUIJsonRet.setSuccessData(total, shipStaffS);
            return miniUIJsonRet;

        } catch(Exception e) {
            ret.setErrTip(ErrCode.GET_ERR);
            LOG.error("query report one err, param:{}", JsonUtil.toJson(param), e);
        }
        return ret;
    }

    @Override
    public List<Map<String,Object>> getReportThreeList(ReportParam param) {
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);
        String time;
        if(!StringUtils.isEmpty(param.getKey())){
            time =param.getKey()+"-01";
        } else {
            return list;
        }
       //time = "2018-03-01";
        try {
            list = shipDAO.queryReportThreeList(time,time,time,time);
        } catch(Exception e) {

            LOG.error("query report one err, param:{}", JsonUtil.toJson(param), e);
        }
        return list;
    }


    @Override
    public List<Map<String,Object>> getReportTwoHeader(ReportParam param) {
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        ShipQuery shipQuery = new ShipQuery();
        if(StringUtils.isEmpty(param.getKey()) && StringUtils.isEmpty(param.getName())){
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            param.setKey( formatter.format(currentTime) );
        }
        BeanUtils.copyProperties(param, shipQuery);
        try {
            ShipDBQuery shipDBQuery = shipQueryConverter.toDOCondition(shipQuery);
            List<Map<String,Object>>  listDao = shipDAO.getReportTwoHeader(shipDBQuery);
            Map mapt = new HashMap();
            mapt.put("field","xh");
            mapt.put("headerAlign","center");
            mapt.put("width","15");
            mapt.put("header","序号");
            list.add(mapt);
            Map mapch = new HashMap();
            mapch.put("field","ch");
            mapch.put("headerAlign","center");
            mapch.put("width","50");
            mapch.put("header","船号");
            list.add(mapch);
            if(listDao.size() >0 ){
                String str[] = (listDao.get(0).get("lx")+"").split(",");
                for(int i = 0; i<str.length;i++){
                    Map map = new HashMap();
                    map.put("field","id"+(i+1));
                    map.put("name","name"+(i+1));
                    map.put("header",(i+1));
                    map.put("headerAlign","center");
                    map.put("width","120");
                    list.add(map);
                }
            }
            Map mapb = new HashMap();
            mapb.put("field","hj");
            mapb.put("name","hj");
            mapb.put("header","合计");
            mapb.put("headerAlign","center");
            mapb.put("width","30");
            list.add(mapb);

        } catch(Exception e) {

            LOG.error("query report one err, param:{}", JsonUtil.toJson(param), e);
        }
        return list;
    }

    @Override
    public List<Map<String,Object>> getReportTwoList(ReportParam param) {
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        ShipQuery shipQuery = new ShipQuery();
        if(StringUtils.isEmpty(param.getKey()) && StringUtils.isEmpty(param.getName())){
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
            param.setKey( formatter.format(currentTime) );
        }
        BeanUtils.copyProperties(param, shipQuery);
        try {
            ShipDBQuery shipDBQuery = shipQueryConverter.toDOCondition(shipQuery);
            List<Map<String,Object>>  listDao = shipDAO.getReportTwoList(shipDBQuery);
            for(int j=0;j<listDao.size();j++){
                String strSj[] = (listDao.get(j).get("sj")+"").split(",");
                String strReceiver[] = (listDao.get(j).get("receiver")+"").split(",");
                String strSender[] = (listDao.get(j).get("sender")+"").split(",");
                String strLx[] = (listDao.get(j).get("lx")+"").split(",");
                Map map = new HashMap();
                map.put("xh",(j+1));
                map.put("ch",(listDao.get(j).get("shipNo")+""));
                for(int i = 0; i<strLx.length;i++){

                    // 1：熟料  2：散装  3：集装箱'
                    //实际发货日期+收货单位（熟料），实际发货日期+发货单位发货地+收货单位（散装）
                    if("1".equals(strLx[i])){
                        map.put("id"+(i+1),strSj[i]+strReceiver[i]);
                    }else {
                        map.put("id"+(i+1),strSj[i]+strSender[i]+strReceiver[i]);
                    }

                }
                map.put("hj",strLx.length);
                list.add(map);

            }


        } catch(Exception e) {

            LOG.error("query report one err, param:{}", JsonUtil.toJson(param), e);
        }
        return list;
    }

    @Override
    public List<Map<String,Object>> getFlowByContractId(ReportParam param) {
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);

        if(StringUtils.isEmpty(param.getKey())){
            return list;
        }
        try {
            list = shipDAO.getFlowByContractId(param.getKey());
        } catch(Exception e) {
            LOG.error("query getFlowByContractId err, param:{}", JsonUtil.toJson(param), e);
        }
        return list;
    }

    @Override
    public List<Map<String,Object>> getReportFour2ThreeList(ReportParam param) {
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);
        String time =param.getKey();
       /* if(!StringUtils.isEmpty(param.getKey())){
            time =param.getKey();
        } else {
            return list;
        }*/
        //time = "2018-03-01";
        try {
            list = shipDAO.getReportFour2ThreeList(time,time);
        } catch(Exception e) {

            LOG.error("query report one err, param:{}", JsonUtil.toJson(param), e);
        }
        return list;
    }

    @Override
    public List<Map<String,Object>> getReportFour2TwoList(ReportParam param) {
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);
        String time =param.getKey();
        /*if(!StringUtils.isEmpty(param.getKey())){
            time =param.getKey();
        } else {
            return list;
        }*/
        //time = "2018-03-01";
        try {
            list = shipDAO.getReportFour2TwoList(time,time);
        } catch(Exception e) {

            LOG.error("query report one err, param:{}", JsonUtil.toJson(param), e);
        }
        return list;
    }

    @Override
    public List<Map<String,Object>> getReportFour2OneList(ReportParam param) {
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);
        String time =param.getKey();
       /* if(!StringUtils.isEmpty(param.getKey())){
            time =param.getKey();
        } else {
            return list;
        }*/
        //time = "2018-03-01";
        try {
            list = shipDAO.getReportFour2OneList(time,time,time,time);
        } catch(Exception e) {

            LOG.error("query report one err, param:{}", JsonUtil.toJson(param), e);
        }
        return list;
    }

    @Override
    public List<Map<String,Object>> getReportFour2FourList(ReportParam param) {
        List<Map<String,Object>>  list = new ArrayList<Map<String,Object>>();
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);
        String time =param.getKey();
       /* if(!StringUtils.isEmpty(param.getKey())){
            time =param.getKey();
        } else {
            return list;
        }*/
        //time = "2018-03-01";
        try {
            list = shipDAO.getReportFour2FourList(time,time);
        } catch(Exception e) {

            LOG.error("query report one err, param:{}", JsonUtil.toJson(param), e);
        }
        return list;
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

        //余量确认

        try {
            updateList.forEach(o->{
                boolean isNeedSendMsgToDev = false;
                if (PrimitiveUtil.getPrimitive(o.getStashStatus()) == 1) {//暂存状态
                    o.setStatus(-1);
                } else {
                    DispatchInfoDO dispatchInfoDO = dispatchInfoDAO.getById(o.getId());
                    if (dispatchInfoDO != null && dispatchInfoDO.getStatus() == -1) {//对于原来是未调度的，修改后将其变成已调度
                        o.setStatus(0);
                        isNeedSendMsgToDev = true;

                    }
                }
                o.setCustomerTaskFlowId(dispatchInfoParam.getCustomerTaskFlowId());
                dispatchInfoDAO.update(dispatchInfoConverter.toDataObject(o));
                if (isNeedSendMsgToDev) {
                    sendMsgToDev(o);
                }
            });

            delList.forEach(o->{
                o.setCustomerTaskFlowId(dispatchInfoParam.getCustomerTaskFlowId());
                dispatchInfoDAO.del(o.getId());
                sendMsgToDev(o);
            });

            addList.forEach(o->{
                boolean isNeedSendMsgToDev = false;
                if (PrimitiveUtil.getPrimitive(o.getStashStatus()) == 1) {//暂存状态
                    o.setStatus(-1);
                } else {
                    isNeedSendMsgToDev = true;
                }
                o.setCustomerTaskFlowId(dispatchInfoParam.getCustomerTaskFlowId());
                DispatchInfoDO dispatchInfoDO = dispatchInfoConverter.toDataObject(o);
                dispatchInfoDAO.insertSelective(dispatchInfoDO);
                o.setId(dispatchInfoDO.getId());
                if (isNeedSendMsgToDev) {
                    sendMsgToDev(o);
                }
            });

            taskStatusService.updateCustomerTaskFlowTaskStatus4Dispatch(dispatchInfoParam.getCustomerTaskFlowId());
            ret.setSuccessData(true);
        } catch (Exception e) {
            LOG.error("confirmDispatchInfoPlan err, param:{}", JsonUtil.toJson(dispatchInfoParam), e);
        }
        return ret;
    }

    private void sendMsgToDev(DispatchFlagInfo dispatchFlagInfo) {
        try {
            DispatchPlan plan = new DispatchPlan();
            if (dispatchFlagInfo.getId() != null) {
                plan.setDispatchplansendid(dispatchFlagInfo.getId());
            }
            if (dispatchFlagInfo.getFlag() == 2) {
                sendMessageServer.funSendCancelMsg(plan);
                LOG.info("send cancel msg to dev, planID:{}", dispatchFlagInfo.getId());
                return;
            }

            JsonRet<Ship> shipRet = shipService.getById(dispatchFlagInfo.getShipId());
            if (!shipRet.isSuccess() || shipRet.getData() == null) {
                LOG.error("no ship found by id:{}, can't send msg to dev", dispatchFlagInfo.getShipId());
                return;
            }
            JsonRet<CustomerTaskFlow> customerTaskFlowRet = customerTaskFlowService.getById(dispatchFlagInfo.getCustomerTaskFlowId());
            if (!customerTaskFlowRet.isSuccess() || customerTaskFlowRet.getData() == null) {
                LOG.error("no customer task flow found by id:{}, can't send msg to dev", dispatchFlagInfo.getCustomerTaskFlowId());
                return;
            }
            Ship ship = shipRet.getData();
            CustomerTaskFlow customerTaskFlow = customerTaskFlowRet.getData();


            plan.setTaskname("任务:" + dispatchFlagInfo.getId());
            plan.setDevicecode(ship.getGpsDeviceId());
            plan.setPlanruntime(DateUtils.formatDatetime(customerTaskFlow.getLoadingTime() * 1000));
            plan.setStartfieldcode(String.valueOf(customerTaskFlow.getStartPortId()));
            plan.setStartfieldname("出发港口" + customerTaskFlow.getStartPortId());
            plan.setEndfieldcode(String.valueOf(customerTaskFlow.getEndPortId()));
            plan.setEndfieldname("抵达港口" + customerTaskFlow.getEndPortId());
            plan.setServertime(DateUtils.getCurrentSystemTime());
            plan.setStartplanarrivetime(DateUtils.formatDatetime(dispatchFlagInfo.getPreArriveTime() * 1000));
            plan.setPlanarrivetime(DateUtils.formatDatetime(customerTaskFlow.getDischargeTime() * 1000));
            plan.setGoodsname(customerTaskFlow.getGoodsName());
            plan.setGoodstype(String.valueOf(customerTaskFlow.getGoodsType()));
            plan.setPlanton(String.valueOf(dispatchFlagInfo.getPreLoad()));
            plan.setRealton("");
            sendMessageServer.funSendMsg(plan);
            LOG.info("send msg to dev, content:{}", JsonUtil.toJson(plan));
        } catch (Exception e) {
            LOG.error("send msg to dev err, dispatchInfo:{}", JsonUtil.toJson(dispatchFlagInfo), e);
        }
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

    @Override
    public JsonRet<Object> getReportSixList(ReportParam param) {
        JsonRet<Object> ret = new JsonRet<>();
        if (!ParamValidator.isParamValid(ret, param)) {
            return ret;
        }
        ShipQuery shipQuery = new ShipQuery();
        BeanUtils.copyProperties(param, shipQuery);

        try {
            ShipDBQuery shipDBQuery = shipQueryConverter.toDOCondition(shipQuery);
            int total = shipDAO.queryReportSixCount(shipDBQuery);
            List<Map<String,Object>> shipStaffS = null;
            if (total > 0) {
                shipStaffS = shipDAO.queryReportSixList(shipDBQuery);
            }
            MiniUIJsonRet<Object> miniUIJsonRet = new MiniUIJsonRet<>();
            miniUIJsonRet.setSuccessData(total, shipStaffS);
            return miniUIJsonRet;

        } catch(Exception e) {
            ret.setErrTip(ErrCode.GET_ERR);
            LOG.error("query report six err, param:{}", JsonUtil.toJson(param), e);
        }
        return ret;
    }
}
