package com.xingyi.logistic.business.util;

/**
 * Created by Jadic on 2017/12/31.
 */
public class PrimitiveUtil {

    /**
     * 获取Integer对应int值，为null时默认返回0
     * @param v
     * @return
     */
    public static int getPrimitive(Integer v) {
        return getPrimitive(v, 0);
    }

    /**
     * 获取Integer基础类型值，为null时返回defVal
     * @param v
     * @param defVal
     * @return
     */
    public static int getPrimitive(Integer v, int defVal) {
        return v != null ? v : defVal;
    }

    /**
     * 获取Long对应int值，为null时默认返回0
     * @param v
     * @return
     */
    public static long getPrimitive(Long v) {
        return getPrimitive(v, 0);
    }

    /**
     * 获取Long基础类型值，为null时返回defVal
     * @param v
     * @param defVal
     * @return
     */
    public static long getPrimitive(Long v, long defVal) {
        return v != null ? v : defVal;
    }

    public static boolean getPrimitive(Boolean v, boolean defVal) {
        return v != null ? v : defVal;
    }

    public static boolean isGTZero(Long l) {
        return l != null && l > 0;
    }

}
