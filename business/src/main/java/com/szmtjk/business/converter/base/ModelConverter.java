package com.szmtjk.business.converter.base;

public abstract class ModelConverter<DO, MODEL> {

    public abstract DO toDataObject(MODEL model);

    public abstract MODEL toModel(DO data);

}