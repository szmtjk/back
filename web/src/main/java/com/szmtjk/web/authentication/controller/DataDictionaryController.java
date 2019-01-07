package com.szmtjk.web.authentication.controller;

import com.szmtjk.authentication.model.DataDictionary;
import com.szmtjk.authentication.model.DataDictionaryQuery;
import com.szmtjk.authentication.service.DataDictionaryService;
import com.szmtjk.business.service.base.BaseService;
import com.xxx.common.bean.JsonRet;
import com.szmtjk.web.config.JsonParam;
import com.szmtjk.web.controller.base.BaseCRUDController;
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