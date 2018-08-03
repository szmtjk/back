package com.xingyi.logistic.business.service.common;

import com.xingyi.logistic.business.db.dao.PushAppMsgDAO;
import com.xingyi.logistic.business.db.entity.PushAppMsgDBQuery;
import com.xingyi.logistic.business.db.entity.PushAppMsgDO;
import com.xingyi.logistic.business.model.PushAppMsg;
import com.xingyi.logistic.business.model.ReservationCheckFlagInfo;
import com.xingyi.logistic.business.service.PushAppMsgService;
import com.xingyi.logistic.business.util.JPushClientUtil;
import com.xingyi.logistic.qiangdan.model.Reservation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xiaohu on 2018/6/28.
 */
@Service
public class PushService {

    private static final Logger LOG = LoggerFactory.getLogger(PushService.class);

    @Autowired
    PushAppMsgDAO pushAppMsgDAO;

    /**
     * 推送预约通过信息
     * @param reservation 预约信息
     * @param reservationCheckFlagInfo 预约审核信息
     */
    public void pushReservationPassed(Reservation reservation, ReservationCheckFlagInfo reservationCheckFlagInfo) {
        if (reservation == null) {
            return;
        }
        String notificationTitle = "兴一物流";
        String msgTitle = "预约通过";
        String msgContent = "您申请的预约已被通过。";
        String extrasParam = "";
        JPushClientUtil.sendToAliasUser(notificationTitle, msgTitle, msgContent, extrasParam, String.valueOf(reservation.getUserId()));
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

    /**
     * 推送预约失败信息
     * @param reservation 预约信息
     * @param reservationCheckFlagInfo 预约审核信息
     */
    public void pushReservationFalsed(Reservation reservation, ReservationCheckFlagInfo reservationCheckFlagInfo) {
        if (reservation == null) {
            return;
        }
        String notificationTitle = "兴一物流";
        String msgTitle = "预约失败";
        String msgContent = "您申请的预约未通过。";
        String extrasParam = "";
        JPushClientUtil.sendToAliasUser(notificationTitle, msgTitle, msgContent, extrasParam, String.valueOf(reservation.getUserId()));
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
