package com.xingyi.logistic.common.bean;

/**
 * Created by Jadic on 2017/6/15.
 */
public final class Const {

    public static final int PARK_STATUS_PARKING = 0;//停车中
    public static final int PARK_STATUS_DONE = 1;//停车已结束
    public static final int PARK_AMOUNT_STATUS_AUTO = 1;//停车金额系统自动设置

    public static final int PARK_AMOUNT_STATUS_MANUAL = 1;//停车金额人工设置
    public static final int MEMBER_FEE = 99999999;//计算停车费时，如果是会员，返回的特殊价格

    public static final int WASH_STATUS_WAITING = 0;//等等洗车
    public static final int WASH_STATUS_STARTED = 10;//洗车开始
    public static final int WASH_STATUS_END = 20;//洗车结束
    public static final int WASH_STATUS_EXIT = 30;//出场

}
