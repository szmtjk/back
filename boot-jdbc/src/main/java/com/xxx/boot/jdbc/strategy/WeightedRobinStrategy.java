package com.xxx.boot.jdbc.strategy;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.xxx.boot.jdbc.support.MathHelper;

/**
 * 权重轮询
 * Date: 2015-09-30
 *
 * @author luoxiaoyong
 */
public class WeightedRobinStrategy<T> implements LoaderStrategy<T> {
    private final AtomicInteger currentIndex = new AtomicInteger(-1);// 上一次选择的服务器
    private final AtomicInteger currentWeight = new AtomicInteger(0);// 当前调度的权值
    private int maxWeight = 0; // 最大权重
    private int gcdWeight = 0; //所有权重的最大公约数
    private int count = 0; //数量
    private List<T> source; //集合
    private List<Integer> weights; //权重
    private static final int THRESHOLD = Integer.MAX_VALUE/10;

    public WeightedRobinStrategy(List<T> source, List<Integer> weights) {
        this.source = source;
        this.weights = weights;
        init();
    }

    private void init(){
        if(this.source == null || this.weights == null || this.source.isEmpty() || this.weights.isEmpty()) {
            throw new RuntimeException("calculation weight fail, source is empty");
        }
        if(source.size() != weights.size()){
            throw new RuntimeException("the size of source collection is different from weights");
        }
        count = source.size();
        gcdWeight = getGCDForServers();
        maxWeight = getMaxWeightForServers();
    }

    /**
     * 返回最大公约数
     * @param a
     * @param b
     * @return
     */
    private int gcd(int a, int b) {
        BigInteger b1 = new BigInteger(String.valueOf(a));
        BigInteger b2 = new BigInteger(String.valueOf(b));
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }


    /**
     * 返回所有权重的最大公约数
     * @return
     */
    private int getGCDForServers() {
        int w = 0;
        for (int i = 0, len = weights.size(); i < len - 1; i++) {
            if (w == 0) {
                w = gcd(weights.get(i), weights.get(i + 1));
            } else {
                w = gcd(w, weights.get(i + 1));
            }
        }
        return w;
    }


    /**
     * 返回所有服务器中的最大权重
     * @return
     */
    private int getMaxWeightForServers() {
        int w = 0;
        for (int i = 0, len = weights.size(); i < len - 1; i++) {
            if (w == 0) {
                w = Math.max(weights.get(i), weights.get(i + 1));
            } else {
                w = Math.max(w, weights.get(i + 1));
            }
        }
        return w;
    }

    /**
     *  算法流程：
     *  假设有一组服务器 S = {S0, S1, …, Sn-1}
     *  有相应的权重，变量currentIndex表示上次选择的服务器
     *  权值currentWeight初始化为0，currentIndex初始化为-1 ，当第一次的时候返回 权值取最大的那个服务器，
     *  通过权重的不断递减 寻找 适合的服务器返回，直到轮询结束，权值返回为0
     */
    @Override
    public T process() {
        while (true) {
            if(currentIndex.get() > THRESHOLD) {
                currentIndex.set(0);
            }
            int index = currentIndex.incrementAndGet();
            index = MathHelper.mod(index, count);

            if (index == 0) {
                currentWeight.addAndGet(-gcdWeight);
                // 可能发生竞态条件，不是原子操作
                if (currentWeight.get() <= 0) {
                    currentWeight.set(maxWeight);
                    if (currentWeight.get() == 0){
                        return null;
                    }
                }
            }
            if (weights.get(index) >= currentWeight.get()) {
                return source.get(index);
            }
        }
    }

    public void setWeights(List<Integer> weights) {
        this.weights = weights;
    }

    public void setSource(List<T> source) {
        this.source = source;
    }
}


