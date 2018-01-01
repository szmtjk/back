package com.xxx.boot.jdbc.support;

/**
 * Date: 2015-09-30
 *
 * @author luoxiaoyong
 */
public class MathHelper {
    /**
     * 求模left%right
     * @param left
     * @param right
     * @return
     */
    public static int mod(int left, int right){
        if(right == 0) {
            return 0;
        }
        return left - (left/right)*right;
    }
}
