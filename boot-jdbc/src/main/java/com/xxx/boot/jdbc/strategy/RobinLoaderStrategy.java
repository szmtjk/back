package com.xxx.boot.jdbc.strategy;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.xxx.boot.jdbc.support.MathHelper;

/**
 * Date: 2015-09-30
 *
 * @author luoxiaoyong
 */
public class RobinLoaderStrategy<T> implements LoaderStrategy<T> {
    private final AtomicInteger count = new AtomicInteger(0);
    private static final int THRESHOLD = Integer.MAX_VALUE/10;
    private List<T> source;

    public RobinLoaderStrategy(List<T> source) {
        this.source = source;
        init();
    }
    private void init(){
        if(source == null || source.isEmpty()){
            throw new RuntimeException("calculation robin fail, source is empty");
        }
    }

    @Override
    public T process() {
        int index = count.getAndIncrement();
        if(index > THRESHOLD) {
            count.set(0);
        }
        return source.get(MathHelper.mod(index, source.size()));
    }

    public void setSource(List<T> source) {
        this.source = source;
    }
}
