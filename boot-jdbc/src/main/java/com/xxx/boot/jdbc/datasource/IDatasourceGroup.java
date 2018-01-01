package com.xxx.boot.jdbc.datasource;

import java.util.List;

/**
 * Date: 2015-09-24
 *
 * @author luoxiaoyong
 */
public interface IDatasourceGroup {
    DatasourceDescription getMaster();
    List<DatasourceDescription> getSlaves();
    String getId();
    void setMaster(DatasourceDescription master);
    void addSlave(DatasourceDescription slave);
    void setId(String id);
}
