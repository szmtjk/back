package com.szmtjk.business.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Created by xiaohu on 2019/1/7.
 */
public class SMSUtil {

    private static final Logger LOG = LoggerFactory.getLogger(SMSUtil.class);

    private static final String mobileRegex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
    private static final Pattern MOBILE_PATTERN = Pattern.compile(mobileRegex, Pattern.CASE_INSENSITIVE);

    private static final String PRODUCT = "Dysmsapi";//短信API产品名称（短信产品名固定，无需修改）
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";//短信API产品域名（接口地址固定，无需修改）

    private static final String ACCESS_KEY_ID = "LTAIdUBbFVh4G20g";//你的accessKeyId,参考本文档步骤2
    private static final String ACCESS_KEY_SECRET = "otMlMYMBfdvoLgT3uFmmy9nnILdvyU";//你的accessKeySecret，参考本文档步骤2

    private static final String SIGN_NAME = "明天健康";
    private static final String TEMPLATE_CODE = "SMS_152283651";

    private static IAcsClient acsClient = null;

    public static boolean sendSMS(String mobile, String smsCode) throws ClientException {
        IAcsClient acsClient = getIAcsClient();
        SendSmsRequest request = getSMSRequest(mobile, smsCode);
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if(sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            return true;
        }
        LOG.info("sendSMS, mobile:{}, response:{}", JsonUtil.toJson(sendSmsResponse));
        return false;
    }

    private static IAcsClient getIAcsClient() throws ClientException {
        if (acsClient == null) {
            synchronized (SMSUtil.class) {
                if (acsClient == null) {
                    //初始化ascClient,暂时不支持多region（请勿修改）
                    IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID,
                            ACCESS_KEY_SECRET);
                    DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", PRODUCT, DOMAIN);
                    acsClient = new DefaultAcsClient(profile);
                }
            }
        }
        return acsClient;
    }

    private static SendSmsRequest getSMSRequest(String mobile, String smsCode) {
        //组装请求对象
        SendSmsRequest smsRequest = new SendSmsRequest();
        //使用post提交
        smsRequest.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式；发送国际/港澳台消息时，接收号码格式为国际区号+号码，如“85200000000”
        smsRequest.setPhoneNumbers(mobile);
        //必填:短信签名-可在短信控制台中找到
        smsRequest.setSignName(SIGN_NAME);
        //必填:短信模板-可在短信控制台中找到，发送国际/港澳台消息时，请使用国际/港澳台短信模版
        smsRequest.setTemplateCode(TEMPLATE_CODE);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        smsRequest.setTemplateParam(String.format("{\"code\":\"%s\"}", smsCode));
        return smsRequest;
    }

    /**
     * 校验是否是合法手机号
     * @param mobile
     * @return
     */
    public static boolean isValidMobile(String mobile) {
        return MOBILE_PATTERN.matcher(mobile).matches();
    }

    /**
     * 生成指定长度的随机数字验证码
     * @param length
     * @return
     */
    public static String generateSMSCode(int length) {
        StringBuilder smsCode = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            smsCode.append(random.nextInt(10));
        }
        return smsCode.toString();
    }

    public static String getMaskMobile(String mobile) {
        if (!StringUtils.isEmpty(mobile)) {
            StringBuilder maskMobile = new StringBuilder();
            for (int i = 0; i < mobile.length(); i++) {
                if (i >= 3 && i <= 6) {
                    maskMobile.append('*');
                } else {
                    maskMobile.append(mobile.charAt(i));
                }
            }
            return maskMobile.toString();
        }
        return mobile;
    }

    public static void main(String[] args) {
        System.out.println(getMaskMobile("1871245678"));
    }
}
