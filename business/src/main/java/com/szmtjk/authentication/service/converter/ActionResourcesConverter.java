package com.szmtjk.authentication.service.converter;

import com.szmtjk.authentication.db.entity.ActionResourcesDO;
import com.szmtjk.authentication.model.ActionResources;
import com.szmtjk.business.service.base.ModelConverter;
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
