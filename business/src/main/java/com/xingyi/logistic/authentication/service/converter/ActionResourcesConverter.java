package com.xingyi.logistic.authentication.service.converter;

import com.xingyi.logistic.authentication.db.entity.ActionResourcesDO;
import com.xingyi.logistic.authentication.model.ActionResources;
import com.xingyi.logistic.business.service.base.ModelConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ActionResourcesConverter extends ModelConverter<ActionResourcesDO,ActionResources> {
    @Override
    public ActionResourcesDO toDataObject(ActionResources actionResources) {
        ActionResourcesDO actionResourcesDO = new ActionResourcesDO();
        if(null != actionResources){
            BeanUtils.copyProperties(actionResources, actionResourcesDO);
        }
        return actionResourcesDO;
    }

    @Override
    public ActionResources toModel(ActionResourcesDO data) {
        ActionResources actionResources = new ActionResources();
        if(null != data){
            BeanUtils.copyProperties(data, actionResources);
        }
        return actionResources;
    }
}
