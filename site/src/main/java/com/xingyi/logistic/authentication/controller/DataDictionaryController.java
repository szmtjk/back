package com.xingyi.logistic.authentication.controller;

import com.xingyi.logistic.authentication.model.DataDictionary;
import com.xingyi.logistic.authentication.model.DataDictionaryQuery;
import com.xingyi.logistic.authentication.service.DataDictionaryService;
import com.xingyi.logistic.business.service.BaseService;
import com.xingyi.logistic.common.bean.JsonRet;
import com.xingyi.logistic.config.JsonParam;
import com.xingyi.logistic.controller.BaseCRUDController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/dataDictionary")
@RestController
public class DataDictionaryController extends BaseCRUDController<DataDictionary,DataDictionaryQuery> {
    @Autowired
    private DataDictionaryService dataDictionaryService;

    @RequestMapping(value = "/getTree", method = RequestMethod.GET)
    public Object getTree(@JsonParam DataDictionaryQuery dataDictionaryQuery) {
        JsonRet<Object> ret = super.getList(dataDictionaryQuery);
        if (ret.isSuccess())
        {
            return ret.getData();
        }
        return null;
    }

    @Override
    protected BaseService<DataDictionary,DataDictionaryQuery> getBaseService() {
        return this.dataDictionaryService;
    }
}
