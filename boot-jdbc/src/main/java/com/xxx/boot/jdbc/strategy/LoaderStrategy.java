package com.xxx.boot.jdbc.strategy;

/**
 * slave负载均衡选择策略
 * Date: 2015-09-30
 *
 * @author luoxiaoyong
 */
public interface LoaderStrategy<T> {
    T process();
}
