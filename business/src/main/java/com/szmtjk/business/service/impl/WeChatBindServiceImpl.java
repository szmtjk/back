package com.szmtjk.business.service.impl;

import com.szmtjk.authentication.model.LocalAuth;
import com.szmtjk.authentication.model.LocalAuthQuery;
import com.szmtjk.authentication.service.LocalAuthService;
import com.szmtjk.authentication.service.wechat.WeChatService;
import com.szmtjk.business.bean.wechat.AppSecretConfig;
import com.szmtjk.business.bean.wechat.AppType;
import com.szmtjk.business.bean.wechat.OpenIdResponse;
import com.szmtjk.business.bean.wechat.ThirdType;
import com.szmtjk.business.bean.wechat.UnionIdResponse;
import com.szmtjk.business.model.User;
import com.szmtjk.business.model.UserQuery;
import com.szmtjk.business.model.UserThirdParty;
import com.szmtjk.business.model.UserThirdPartyDetail;
import com.szmtjk.business.model.UserThirdPartyDetailQuery;
import com.szmtjk.business.model.UserThirdPartyQuery;
import com.szmtjk.business.service.UserService;
import com.szmtjk.business.service.UserThirdPartyDetailService;
import com.szmtjk.business.service.UserThirdPartyService;
import com.szmtjk.business.service.WeChatBindService;
import com.szmtjk.business.util.DateUtils;
import com.szmtjk.business.util.PrimitiveUtil;
import com.szmtjk.business.util.SMSCodeCache;
import com.szmtjk.business.util.SMSUtil;
import com.xxx.common.bean.ErrCode;
import com.xxx.common.bean.JsonRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * Created by xiaohu on 2018/11/2.
 */
@Service
public class WeChatBindServiceImpl implements WeChatBindService {

    private static final Logger LOG = LoggerFactory.getLogger(WeChatBindServiceImpl.class);

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private UserThirdPartyService userThirdPartyService;

    @Autowired
    private UserThirdPartyDetailService userThirdPartyDetailService;

    @Autowired
    private LocalAuthService localAuthService;

    @Autowired
    private UserService userService;

    @Autowired
    private SMSCodeCache smsCodeCache;

    @Value("#{30L * 24L * 3600L * 1000L}")
    private long tokenExpire;

    @Override
    public JsonRet<Object> checkBind(String code, int appType) {
        LOG.info("checkBind, code:{}, appType:{}", code, appType);
        if (StringUtils.isEmpty(code)) {
            return JsonRet.getErrRet(ErrCode.WECHAT_CODE_EMPTY);
        }
        //根据appType获取相应的appId, appSecret
        AppSecretConfig appSecretConfig = weChatService.getAppSecretConfig(appType);
        if (appSecretConfig == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_APP_TYPE_INVALID);
        }

        JsonRet<String> unionIdRet;
        if (appType == AppType.MP) {
            unionIdRet = getUnionIdFromMP(appSecretConfig, code);
        } else if (appType == AppType.MINI_PROGRAM) {
            unionIdRet = getUnionIdFromMiniProgram(appSecretConfig, code);
        } else {
            return JsonRet.getErrRet(ErrCode.WECHAT_APP_TYPE_INVALID);
        }
        if (!unionIdRet.isSuccess()) {
            return JsonRet.getErrRet(unionIdRet.getErrCode(), unionIdRet.getMsg());
        }
        String unionId = unionIdRet.getData();
        LOG.info("checkBind, unionId:{}", unionId);

        //根据unionId获取user信息
        UserThirdPartyQuery queryParam = new UserThirdPartyQuery();
        queryParam.setThirdId(unionId);
        queryParam.setThirdType(ThirdType.WECHAT);
        JsonRet<List<UserThirdParty>> userThirdPartyRet = userThirdPartyService.getList(queryParam);
        if (!userThirdPartyRet.isSuccess() || CollectionUtils.isEmpty(userThirdPartyRet.getData())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_NOT_BIND);
        }
        UserThirdParty userThirdParty = userThirdPartyRet.getData().get(0);
        JsonRet<User> userRet = userService.getById(userThirdParty.getUserId());
        if (!userRet.isSuccess() || userRet.getData() == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_BIND_USER_NOT_EXIST);
        }
        User user = userRet.getData();
        LOG.info("checkBind, unionId:{} bind to userName:{}, mobile", unionId, user.getUserName(), user.getMobile());
        //如果是来自小程序的，则执行登录过程，返回token，其余的则返回绑定的userName
//        if (appType == AppType.MINI_PROGRAM) {
////            long expire = System.currentTimeMillis() + this.tokenExpire;
////            String md5 = DigestUtil.md5(String.valueOf(localAuth.getUserId()), localAuth.getLoginName(), localAuth.getPasswd(), String.valueOf(expire));
////            String token = localAuth.getUserId() + ":" + md5 + ":" + expire;
////            token = Base64Utils.encodeToString(token.getBytes());
//            return JsonRet.getSuccessRet(token);
//        } else {
//        }
        return JsonRet.getSuccessRet(SMSUtil.getMaskMobile(user.getMobile()));
    }

    @Override
    public JsonRet<Object> bindFromMP(String code, String userName, String userPass) {
        LOG.info("bind from mp, code:{}, userName:{}", code, userName);
        // 校验用户名、密码是否正确 从SignController中拷贝
        LocalAuthQuery localAuthQuery = new LocalAuthQuery(userName);
        JsonRet<List<LocalAuth>> localAuthRet = this.localAuthService.getList(localAuthQuery);
        List<LocalAuth> localAuthList = localAuthRet.getData();

        //账号不存在
        if (CollectionUtils.isEmpty(localAuthList)) {
            return JsonRet.getErrRet(ErrCode.AUTHTICATION_NOT_EXIST);
        }

        LocalAuth localAuth = localAuthList.get(0);
        String localPasswd = localAuth.getPasswd();
        //密码错误
        if (!org.apache.commons.lang3.StringUtils.equals(userPass, localPasswd)) {
            return JsonRet.getErrRet(ErrCode.AUTHTICATION_PASSWD_ERROR);
        }

        //校验后台用户是否已经被其他用户绑定
        UserThirdPartyQuery queryParam = new UserThirdPartyQuery();
        queryParam.setUserId(localAuth.getUserId());
        queryParam.setThirdType(ThirdType.WECHAT);
        JsonRet<List<UserThirdParty>> userThirdPartyRet = userThirdPartyService.getList(queryParam);
        UserThirdParty userThirdPartyBound = null;
        if (userThirdPartyRet.isSuccess() && !CollectionUtils.isEmpty(userThirdPartyRet.getData())) {
            userThirdPartyBound = userThirdPartyRet.getData().get(0);
            LOG.info("bind from mp, sys user:{} bound to wechat user:{}", userName, userThirdPartyBound.getThirdName());
        }

        // 获取微信用户信息
        JsonRet<UnionIdResponse> unionIdRet = getUnionId(code, AppType.MP);
        if (!unionIdRet.isSuccess()) {
            return JsonRet.getErrRet(unionIdRet.getErrCode(), unionIdRet.getMsg());
        }
        UnionIdResponse unionIdResponse = unionIdRet.getData();

        // 如果当前系统账号已绑定至某个微信账号
        if (userThirdPartyBound != null) {
            if (Objects.equals(unionIdResponse.getUnionId(), userThirdPartyBound.getThirdId())) {// 与当前微信账号一致，则提示已绑定
                return JsonRet.getErrRet(ErrCode.WECHAT_ALREADY_BIND);
            } else {// 与当前微信账号不一致，则提示已绑定其他微信账号信息，当前操作中断
                return JsonRet.getErrRet(ErrCode.WECHAT_SYS_USER_BIND_BY_OTHER_ERR.getCode(), "当前系统账号已被其他微信账号绑定:" + userThirdPartyBound.getThirdName());
            }
        }

        // 校验当前微信用户是否已经绑定
        queryParam = new UserThirdPartyQuery();
        queryParam.setThirdId(unionIdResponse.getUnionId());
        queryParam.setThirdType(ThirdType.WECHAT);
        userThirdPartyRet = userThirdPartyService.getList(queryParam);
        if (userThirdPartyRet.isSuccess() && !CollectionUtils.isEmpty(userThirdPartyRet.getData())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_ALREADY_BIND);
        }

        // 建立绑定关系
        JsonRet<Long> detailAddRet = addThirdPartDetail(unionIdResponse, ThirdType.WECHAT, AppType.MP);
        if (detailAddRet.isSuccess()) {
            JsonRet<Long> addRet = addThirdParty(unionIdResponse, localAuth.getUserId());
            if (addRet.isSuccess()) {
                return JsonRet.getSuccessRet(true);
            }
        }

        return JsonRet.getErrRet(ErrCode.WECHAT_BIND_ERR);
    }

    @Override
    public JsonRet<Object> unbindFromMP(String code) {
        // 获取微信用户信息
        JsonRet<UnionIdResponse> unionIdRet = getUnionId(code, AppType.MP);
        if (!unionIdRet.isSuccess()) {
            return JsonRet.getErrRet(unionIdRet.getErrCode(), unionIdRet.getMsg());
        }

        // 校验当前微信用户是否已经绑定
        UnionIdResponse unionIdResponse = unionIdRet.getData();
        UserThirdPartyQuery queryParam = new UserThirdPartyQuery();
        queryParam.setThirdId(unionIdResponse.getUnionId());
        JsonRet<List<UserThirdParty>> userThirdPartyRet = userThirdPartyService.getList(queryParam);
        if (!userThirdPartyRet.isSuccess() || CollectionUtils.isEmpty(userThirdPartyRet.getData())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_NOT_BIND);
        }

        //解除绑定关系
        UserThirdParty userThirdParty = userThirdPartyRet.getData().get(0);
        JsonRet<Boolean> delRet = userThirdPartyService.del(userThirdParty.getId());
        if (delRet.isSuccess()) {
            userThirdPartyDetailService.delByThirdId(userThirdParty.getThirdId(), userThirdParty.getThirdType());
            return JsonRet.getSuccessRet(true);
        } else {
            return JsonRet.getErrRet(ErrCode.WECHAT_UNBIND_ERR);
        }
    }

    @Override
    public JsonRet<Object> sendTestMPMsg(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return JsonRet.getErrRet(ErrCode.PARAM_MISS);
        }
        LocalAuth localAuth = localAuthService.queryByUserName(userName);
        if (localAuth == null) {
            return JsonRet.getErrRet(ErrCode.AUTHTICATION_NOT_EXIST);
        }

        return sendTestMPMsg(localAuth.getUserId(), null, "现在时间:" + DateUtils.formatDatetime(System.currentTimeMillis()));
    }

    @Override
    public JsonRet<Object> sendTestMPMsg(Long userId, String testFirst, String testRemark) {
        UserThirdPartyQuery queryParam = new UserThirdPartyQuery();
        queryParam.setUserId(userId);
        queryParam.setThirdType(ThirdType.WECHAT);
        JsonRet<List<UserThirdParty>> userThirdPartyRet = userThirdPartyService.getList(queryParam);
        if (!userThirdPartyRet.isSuccess() || CollectionUtils.isEmpty(userThirdPartyRet.getData())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_NOT_BIND);
        }
        UserThirdParty userThirdParty = userThirdPartyRet.getData().get(0);
        UserThirdPartyDetailQuery detailQuery = new UserThirdPartyDetailQuery();
        detailQuery.setThirdId(userThirdParty.getThirdId());
        detailQuery.setThirdType(ThirdType.WECHAT);
        detailQuery.setAppType(AppType.MP);
        JsonRet<List<UserThirdPartyDetail>> detailListRet = userThirdPartyDetailService.getList(detailQuery);
        if (!detailListRet.isSuccess() || CollectionUtils.isEmpty(detailListRet.getData())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_NOT_BIND);
        }
        UserThirdPartyDetail userThirdPartyDetail = detailListRet.getData().get(0);
        AppSecretConfig appSecretConfig = weChatService.getAppSecretConfig(AppType.MP);
        String accessToken = weChatService.getAccessToken(appSecretConfig.getAppId(), appSecretConfig.getAppSecret());
        String response = weChatService.sendTestTemplateMsg(userThirdPartyDetail.getThirdId2(), accessToken, testFirst, testRemark);
        return JsonRet.getSuccessRet(response);
    }

    @Override
    public JsonRet<Object> bindMobile(String code, String mobile, String smsCode) {
        if (!SMSUtil.isValidMobile(mobile)) {
            return JsonRet.getErrRet(ErrCode.MOBILE_INVALID);
        }
        String smsCodeCached = smsCodeCache.getSMSCode(mobile);
        if (!Objects.equals(smsCode, smsCodeCached)) {
            return JsonRet.getErrRet(ErrCode.SMS_CODE_INVALID);
        }

        // 获取微信用户信息
        JsonRet<UnionIdResponse> unionIdRet = getUnionId(code, AppType.MP);
        if (!unionIdRet.isSuccess()) {
            return JsonRet.getErrRet(unionIdRet.getErrCode(), unionIdRet.getMsg());
        }
        UnionIdResponse unionIdResponse = unionIdRet.getData();

        // 校验手机号是否已绑定某个账号
        User user = getUser(null, mobile);
        if (user != null) {// 手机号已绑定
            UserThirdParty userThirdPartyBound = getUserThirdParty(user.getId(), null);
            if (userThirdPartyBound != null) {
                if (Objects.equals(unionIdResponse.getUnionId(), userThirdPartyBound.getThirdId())) {// 与当前微信账号一致，则提示已绑定
                    return JsonRet.getErrRet(ErrCode.WECHAT_ALREADY_BIND);
                } else {// 与当前微信账号不一致，则提示已绑定其他微信账号信息，当前操作中断
                    return JsonRet.getErrRet(ErrCode.WECHAT_SYS_USER_BIND_BY_OTHER_ERR.getCode(),
                            "当前手机号已被其他微信账号绑定:" + userThirdPartyBound.getThirdName());
                }
            }
        }

        // 校验当前微信号是否已绑定
        UserThirdParty userThirdPartyBound = getUserThirdParty(null, unionIdResponse.getUnionId());
        if (userThirdPartyBound != null) {// 微信号已绑定
            JsonRet<User> userRet = userService.getById(userThirdPartyBound.getUserId());
            if (userRet.isSuccess() && userRet.getData() != null) {
                User boundUser = userRet.getData();
                if (Objects.equals(mobile, boundUser.getMobile())) {
                    return JsonRet.getErrRet(ErrCode.WECHAT_ALREADY_BIND);
                } else {// 与当前手机号不一致，则提示已绑定其他手机号信息，当前操作中断
                    return JsonRet.getErrRet(ErrCode.WECHAT_SYS_USER_BIND_BY_OTHER_MOBILE.getCode(),
                            "当前微信账号已绑定手机:" + SMSUtil.getMaskMobile(boundUser.getMobile()));
                }
            }
        }

        // 执行绑定操作
        if (user == null) {// 当前手机号还未创建账号信息，则新增一个用户基础信息
            user = new User();
            user.setUserName(mobile);
            user.setMobile(mobile);
            JsonRet<Long> addUserRet = userService.add(user);
            if (!addUserRet.isSuccess() || PrimitiveUtil.isGTZero(addUserRet.getData())) {
                return JsonRet.getErrRet(ErrCode.ADD_NEW_USER_ERR);
            }
            user.setId(addUserRet.getData());
        }
        JsonRet<Long> detailAddRet = addThirdPartDetail(unionIdResponse, ThirdType.WECHAT, AppType.MP);
        if (detailAddRet.isSuccess()) {
            JsonRet<Long> addRet = addThirdParty(unionIdResponse, user.getId());
            if (addRet.isSuccess()) {
                return JsonRet.getSuccessRet(true);
            }
        }
        return JsonRet.getErrRet(ErrCode.WECHAT_BIND_ERR);
    }

    @Override
    public JsonRet<Object> unbindMobile(String code, String mobile, String smsCode) {
        return null;
    }

    private JsonRet<String> getUnionIdFromMP(AppSecretConfig appSecretConfig, String code) {
        //获取openId
        OpenIdResponse openIdResponse = weChatService.getOpenId(appSecretConfig.getAppId(), appSecretConfig.getAppSecret(), code);
        if (openIdResponse == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_OPENID_ERR);
        }
        if (StringUtils.isEmpty(openIdResponse.getOpenId())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_OPENID_ERR.getCode(), openIdResponse.getErrMsg());
        }

        //获取unionId
        String openId = openIdResponse.getOpenId();
        UnionIdResponse unionIdResponse = weChatService.getUnionId(openIdResponse.getAccessToken(), openId);
        if (unionIdResponse == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_UNIONID_ERR);
        }
        if (StringUtils.isEmpty(unionIdResponse.getUnionId())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_UNIONID_ERR.getCode(), unionIdResponse.getErrMsg());
        }
        return JsonRet.getSuccessRet(unionIdResponse.getUnionId());
    }

    private JsonRet<String> getUnionIdFromMiniProgram(AppSecretConfig appSecretConfig, String code) {
        //获取openId 小程序中获取openId的时候，如果用户已经关注过公众号，则会直接返回unionId
        OpenIdResponse openIdResponse = weChatService.getMiniProgramOpenId(appSecretConfig.getAppId(), appSecretConfig.getAppSecret(), code);
        if (openIdResponse == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_OPENID_ERR);
        }
        if (StringUtils.isEmpty(openIdResponse.getOpenId())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_OPENID_ERR.getCode(), openIdResponse.getErrMsg());
        }

        if (StringUtils.isEmpty(openIdResponse.getUnionId())) {// 如果小程序返回的结果中午unionId则说明用户未关注过公众号
            return JsonRet.getErrRet(ErrCode.WECHAT_NOT_BIND);
        }
        return JsonRet.getSuccessRet(openIdResponse.getUnionId());
    }

    private JsonRet<UnionIdResponse> getUnionId(String code, int appType) {
        if (StringUtils.isEmpty(code)) {
            return JsonRet.getErrRet(ErrCode.WECHAT_APP_TYPE_INVALID);
        }
        //根据appType获取相应的appId, appSecret
        AppSecretConfig appSecretConfig = weChatService.getAppSecretConfig(appType);
        if (appSecretConfig == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_APP_TYPE_INVALID);
        }

        //获取openId
        OpenIdResponse openIdResponse = weChatService.getOpenId(appSecretConfig.getAppId(), appSecretConfig.getAppSecret(), code);
        if (openIdResponse == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_OPENID_ERR);
        }
        if (StringUtils.isEmpty(openIdResponse.getOpenId())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_OPENID_ERR.getCode(), openIdResponse.getErrMsg());
        }

        //获取unionId
        String openId = openIdResponse.getOpenId();
        UnionIdResponse unionIdResponse = weChatService.getUnionId(openIdResponse.getAccessToken(), openId);
        if (unionIdResponse == null) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_UNIONID_ERR);
        }
        if (StringUtils.isEmpty(unionIdResponse.getUnionId())) {
            return JsonRet.getErrRet(ErrCode.WECHAT_GET_UNIONID_ERR.getCode(), unionIdResponse.getErrMsg());
        }
        return JsonRet.getSuccessRet(unionIdResponse);
    }

    /**
     * 根据用户名或者mobile查询用户信息
     * @param userName
     * @param mobile
     * @return
     */
    private User getUser(String userName, String mobile) {
        if (userName != null || mobile != null) {
            UserQuery userQuery = new UserQuery();
            userQuery.setMobile(mobile);
            userQuery.setUserName(userName);
            JsonRet<List<User>> userListRet = userService.getList(userQuery);
            if (userListRet.isSuccess() && userListRet.getData() != null) {
                return userListRet.getData().get(0);
            }
        }
        return null;
    }
    /**
     * 根据userId或thirdId查询相应三方绑定信息
     * @param userId
     * @param thirdId
     * @return
     */
    private UserThirdParty getUserThirdParty(Long userId, String thirdId) {
        if (userId != null || thirdId != null) {
            UserThirdPartyQuery userThirdPartyQuery = new UserThirdPartyQuery();
            userThirdPartyQuery.setUserId(userId);
            userThirdPartyQuery.setThirdId(thirdId);
            userThirdPartyQuery.setThirdType(ThirdType.WECHAT);
            JsonRet<List<UserThirdParty>> userThirdPartyServiceListRet = userThirdPartyService.getList(userThirdPartyQuery);
            if (userThirdPartyServiceListRet.isSuccess() && !CollectionUtils.isEmpty(userThirdPartyServiceListRet.getData())) {
                return userThirdPartyServiceListRet.getData().get(0);
            }
        }
        return null;
    }

    private JsonRet<Long> addThirdPartDetail(UnionIdResponse unionIdResponse, int thirdType, int appType) {
        UserThirdPartyDetail userThirdPartyDetail = new UserThirdPartyDetail();
        userThirdPartyDetail.setThirdId(unionIdResponse.getUnionId());
        userThirdPartyDetail.setThirdId2(unionIdResponse.getOpenId());
        userThirdPartyDetail.setThirdType(thirdType);
        userThirdPartyDetail.setAppType(appType);
        return userThirdPartyDetailService.add(userThirdPartyDetail);
    }

    private JsonRet<Long> addThirdParty(UnionIdResponse unionIdResponse, long userId) {
        UserThirdParty userThirdParty = new UserThirdParty();
        userThirdParty.setThirdId(unionIdResponse.getUnionId());
        userThirdParty.setThirdType(ThirdType.WECHAT);
        userThirdParty.setThirdName(unionIdResponse.getNickName());
        userThirdParty.setUserId(userId);
        return userThirdPartyService.add(userThirdParty);
    }
}
