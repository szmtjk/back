package com.szmtjk.authentication.model;

import com.szmtjk.authentication.bean.BaseRoles;

import java.util.List;

public class Roles extends BaseRoles{
    private List<ActionResources> resources;

    public List<ActionResources> getResources() {
        return resources;
    }

    public void setResources(List<ActionResources> resources) {
        this.resources = resources;
    }
}