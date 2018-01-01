package com.xxx.boot.jdbc.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

/**
 * 记录同一个组的datasource下，sql session的信息
 * Date: 2015-09-28
 *
 * @author luoxiaoyong
 */
public class SqlSessionReference {
    private String groupId;
    private SqlSession master;
    private List<SqlSession> slaves = new ArrayList<>();
    private List<Integer> weights = new ArrayList<>();

    public SqlSession getMaster() {
        return master;
    }

    public List<SqlSession> getSlaves() {
        return slaves;
    }

    public void setMaster(SqlSession master) {
        this.master = master;
    }
    public void addSlave(SqlSession sqlSession){
        this.slaves.add(sqlSession);
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Integer> getWeights() {
        return weights;
    }
    public void addWeight(int weight) {
        this.weights.add(weight);
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("SqlSessionReference:{");
        buf.append("\n\tgroupId:");
        buf.append(groupId);
        buf.append("\n\tmaster:");
        buf.append(master.getConfiguration().getDatabaseId());
        if(!slaves.isEmpty()){
            buf.append("\n\tslaves:{");
            for(SqlSession sqlSession : slaves){
                buf.append("\n\t\tdatabaseId:");
                buf.append(sqlSession.getConfiguration().getDatabaseId());
            }
            buf.append("\n\t}");
        }

        return buf.toString();
    }
}
