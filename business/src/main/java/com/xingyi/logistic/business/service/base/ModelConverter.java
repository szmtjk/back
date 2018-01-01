package com.xingyi.logistic.business.service.base;

/**
 * Created by Jadic on 2017/12/31.
 */
public abstract class ModelConverter<DO, MODEL> {

    public abstract DO toDataObject(MODEL model);

    public abstract MODEL toModel(DO data);

}
