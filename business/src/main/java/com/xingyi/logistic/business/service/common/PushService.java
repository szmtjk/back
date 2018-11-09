package com.xingyi.logistic.business.service.common;

import com.xingyi.logistic.business.db.dao.PushAppMsgDAO;
import com.xingyi.logistic.business.db.entity.PushAppMsgDBQuery;
import com.xingyi.logistic.business.db.entity.PushAppMsgDO;
import com.xingyi.logistic.business.model.ReservationCheckFlagInfo;
import com.xingyi.logistic.business.service.PushAppMsgService;
import com.xingyi.logistic.business.service.WeChatBindService;
import com.xingyi.logistic.business.util.JPushClientUtil;
import com.xingyi.logistic.qiangdan.model.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaohu on 2018/6/28.
 */
@Service
public class PushService {

    private static final Logger LOG = LoggerFactory.getLogger(PushService.class);

    @Autowired
    PushAppMsgDAO pushAppMsgDAO;

    @Autowired
    PushAppMsgService pushAppMsgService;

    @Autowired
    private WeChatBindService weChatBindService;

    /**
     * 推送预约通过信息
     * @param reservation 预约信息
     * @param reservationCheckFlagInfo 预约审核信息
     */
    public void pushReservationPassed(Reservation reservation, ReservationCheckFlagInfo reservationCheckFlagInfo) {
        if (reservation == null) {
            return;
        }

        Map<String,Object> map = new HashMap<>();
        map.put("leftDispatchId",reservation.getLeftDispatchId());
        map.put("userId",reservation.getUserId());
        map.put("reservationId",reservation.getId());
        PushAppMsgDO pushAppMsgDO = pushAppMsgService.getReservationInfo(map);
        Long loadingTime = pushAppMsgDO.getLoadingTime();
        Date date = new Date(loadingTime*1000);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String loadingTimes = sd.format(date);
        String notificationTitle = "兴一船运抢单";
        String msgTitle = pushAppMsgDO.getGoodsName()+pushAppMsgDO.getDispatchWeight()+"吨已通过审核";
        String msgContent = "您在"+loadingTimes+"预约的"+pushAppMsgDO.getDispatchWeight()+"吨的"+pushAppMsgDO.getGoodsName()+"已通过审核!";
        String extrasParam = "";
        JPushClientUtil.sendToAliasUser(msgTitle, notificationTitle, msgContent, extrasParam, String.valueOf(reservation.getUserId()));
        PushAppMsgDO pushAppMsg = new PushAppMsgDO();
        PushAppMsgDBQuery pushAppMsgDBQuery = new PushAppMsgDBQuery();
        pushAppMsg.setUserId(reservation.getUserId());
        pushAppMsg.setNotificationTitle(notificationTitle);
        pushAppMsg.setMsgTitle(msgTitle);
        pushAppMsg.setMsgContent(msgContent);
        pushAppMsg.setExtrasParam(extrasParam);
        pushAppMsgDAO.insertSelective(pushAppMsg);
        LOG.info("reservation passed, and msg pushed to user:{}", reservation.getUserId());

        //测试推送公众号消息
        weChatBindService.sendTestMPMsg(reservation.getUserId(), msgTitle, msgContent);
    }

    /**
     * 推送预约失败信息
     * @param reservation 预约信息
     * @param reservationCheckFlagInfo 预约审核信息
     */
    public void pushReservationFalsed(Reservation reservation, ReservationCheckFlagInfo reservationCheckFlagInfo) {
        if (reservation == null) {
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("leftDispatchId",reservation.getLeftDispatchId());
        map.put("userId",reservation.getUserId());
        map.put("reservationId",reservation.getId());
        PushAppMsgDO pushAppMsgDO = pushAppMsgService.getReservationInfo(map);
        if (pushAppMsgDO == null) {
            return;
        }
        Long loadingTime = pushAppMsgDO.getLoadingTime();
        Date date = new Date(loadingTime*1000);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String loadingTimes = sd.format(date);
        String notificationTitle = "兴一船运抢单";
        String msgTitle = pushAppMsgDO.getGoodsName()+pushAppMsgDO.getDispatchWeight()+"吨未通过审核";
        String msgContent = "您在"+loadingTimes+"预约的"+pushAppMsgDO.getDispatchWeight()+"吨的"+pushAppMsgDO.getGoodsName()+"未通过审核!";
        String extrasParam = "";
        JPushClientUtil.sendToAliasUser(msgTitle, notificationTitle, msgContent, extrasParam, String.valueOf(reservation.getUserId()));
        PushAppMsgDO pushAppMsg = new PushAppMsgDO();
        PushAppMsgDBQuery pushAppMsgDBQuery = new PushAppMsgDBQuery();
        pushAppMsg.setUserId(reservation.getUserId());
        pushAppMsg.setNotificationTitle(notificationTitle);
        pushAppMsg.setMsgTitle(msgTitle);
        pushAppMsg.setMsgContent(msgContent);
        pushAppMsg.setExtrasParam(extrasParam);
        pushAppMsgDAO.insertSelective(pushAppMsg);
        LOG.info("reservation passed, and msg pushed to user:{}", reservation.getUserId());
    }
}
