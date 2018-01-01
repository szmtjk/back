package com.xxx.boot.jdbc.strategy;

/**
 * 环境角色，主要完成对特定策略的调用
 * Date: 2015-09-30
 *
 * @author luoxiaoyong
 */
public class StrategyContext<T> {
    private LoaderStrategy<T> strategy;

    public StrategyContext(LoaderStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public T process(){
        return strategy.process();
    }
}
