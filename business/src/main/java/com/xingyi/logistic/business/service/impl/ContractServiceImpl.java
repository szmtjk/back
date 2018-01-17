package com.xingyi.logistic.business.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.xingyi.logistic.business.db.dao.ContractDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.ContractDBQuery;
import com.xingyi.logistic.business.db.entity.ContractDO;
import com.xingyi.logistic.business.model.Contract;
import com.xingyi.logistic.business.model.ContractFlow;
import com.xingyi.logistic.business.model.ContractQuery;
import com.xingyi.logistic.business.service.ContractFlowService;
import com.xingyi.logistic.business.service.ContractService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.ContractConverter;
import com.xingyi.logistic.business.service.converter.ContractQueryConverter;
import com.xingyi.logistic.business.util.JsonUtil;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 合同信息
 */
@Service
public class ContractServiceImpl extends BaseCRUDService<ContractDO, Contract, ContractDBQuery, ContractQuery> implements ContractService {

    @Autowired
    private ContractDAO contractDAO ;

    @Autowired
    private ContractFlowService contractFlowService;

    @Autowired
    private ContractConverter contractConverter;

    @Autowired
    private ContractQueryConverter contractQueryConverter;

    @Override
    protected boolean isBizOperationAfterAddPassed(JsonRet<?> ret, Contract contract, ContractDO dataObj) {
        if (!StringUtils.isEmpty(contract.getContractFlows())) {
            List<ContractFlow> contractFlows = JsonUtil.toObject(contract.getContractFlows(), new TypeReference<List<ContractFlow>>() {
            });
            for (ContractFlow contractFlow : contractFlows) {
                contractFlow.setContractId(dataObj.getId());
                contractFlowService.add(contractFlow);
            }
        }
        return true;
    }

    @Override
    protected ModelConverter<ContractDO, Contract> getModelConverter() {
        return contractConverter;
    }

    @Override
    protected BaseDAO<ContractDO, ContractDBQuery> getDAO() {
        return contractDAO;
    }

    @Override
    protected QueryConditionConverter<ContractQuery, ContractDBQuery> getConditionConverter() {
        return contractQueryConverter;
    }
}
