package com.xingyi.logistic.authentication.service.converter;

import com.xingyi.logistic.authentication.db.entity.DataDictionaryDO;
import com.xingyi.logistic.authentication.model.DataDictionary;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DataDictionaryConverter extends ModelConverter<DataDictionaryDO,DataDictionary> {
    @Override
    public DataDictionaryDO toDataObject(DataDictionary dataDictionary) {
        DataDictionaryDO dataDictionaryDO = new DataDictionaryDO();
        if(null != dataDictionary){
            BeanUtils.copyProperties(dataDictionary, dataDictionaryDO);
        }
        return dataDictionaryDO;
    }

    @Override
    public DataDictionary toModel(DataDictionaryDO data) {
        DataDictionary dataDictionary = new DataDictionary();
        if(null != data){
            BeanUtils.copyProperties(data, dataDictionary);
        }
        return dataDictionary;
    }
}
