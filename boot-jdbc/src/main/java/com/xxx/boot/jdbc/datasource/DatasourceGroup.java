package com.xxx.boot.jdbc.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * 一组data sources，包含一组master/slave
 * Date: 2015-09-24
 *
 * @author luoxiaoyong
 */
public class DatasourceGroup implements IDatasourceGroup{
    // master 数据源
    private DatasourceDescription master;
    // slave 数据源
    private List<DatasourceDescription> slaves = new ArrayList<>();
    private String id;


    @Override
    public DatasourceDescription getMaster() {
        return this.master;
    }

    @Override
    public List<DatasourceDescription> getSlaves() {
        return this.slaves;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setMaster(DatasourceDescription master) {
        this.master = master;
    }

    @Override
    public void addSlave(DatasourceDescription slave) {
        this.slaves.add(slave);
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
