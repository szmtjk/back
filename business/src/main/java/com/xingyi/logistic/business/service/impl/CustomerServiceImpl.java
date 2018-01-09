package com.xingyi.logistic.business.service.impl;

import com.xingyi.logistic.business.db.dao.CustomerDAO;
import com.xingyi.logistic.business.db.dao.ShipDAO;
import com.xingyi.logistic.business.db.dao.base.BaseDAO;
import com.xingyi.logistic.business.db.entity.CustomerDBQuery;
import com.xingyi.logistic.business.db.entity.CustomerDO;
import com.xingyi.logistic.business.db.entity.ShipDBQuery;
import com.xingyi.logistic.business.db.entity.ShipDO;
import com.xingyi.logistic.business.model.Customer;
import com.xingyi.logistic.business.model.CustomerQuery;
import com.xingyi.logistic.business.model.Ship;
import com.xingyi.logistic.business.model.ShipQuery;
import com.xingyi.logistic.business.service.CustomerService;
import com.xingyi.logistic.business.service.ShipService;
import com.xingyi.logistic.business.service.base.BaseCRUDService;
import com.xingyi.logistic.business.service.base.ModelConverter;
import com.xingyi.logistic.business.service.base.QueryConditionConverter;
import com.xingyi.logistic.business.service.converter.CustomerConverter;
import com.xingyi.logistic.business.service.converter.CustomerQueryConverter;
import com.xingyi.logistic.business.service.converter.ShipConverter;
import com.xingyi.logistic.business.service.converter.ShipQueryConverter;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Jadic on 2018/1/1.
 */
@Service
public class CustomerServiceImpl extends BaseCRUDService<CustomerDO, Customer, CustomerDBQuery, CustomerQuery> implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private CustomerQueryConverter customerQueryConverter;

    @Override
    protected ModelConverter<CustomerDO, Customer> getModelConverter() {
        return customerConverter;
    }

    @Override
    protected BaseDAO<CustomerDO, CustomerDBQuery> getDAO() {
        return customerDAO;
    }

    @Override
    protected QueryConditionConverter<CustomerQuery, CustomerDBQuery> getConditionConverter() {
        return customerQueryConverter;
    }
}
