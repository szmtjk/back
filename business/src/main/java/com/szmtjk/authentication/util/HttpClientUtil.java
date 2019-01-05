package com.szmtjk.authentication.util;

import com.szmtjk.business.bean.wechat.TemplateMsgData;
import com.szmtjk.business.bean.wechat.ValueColorPair;
import com.szmtjk.business.util.JsonUtil;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 16101934
 * @time 2018/1/27 17:14
 */
public final class HttpClientUtil {

    private static final Logger LOG = LoggerFactory.getLogger(HttpClientUtil.class);

    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static SSLConnectionSocketFactory sslsf = null;
    private static PoolingHttpClientConnectionManager cm = null;
    private static SSLContextBuilder builder = null;
    static {
        try {
            builder = new SSLContextBuilder();
            // 全部信任 不做身份鉴定
            builder.loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            });
            sslsf = new SSLConnectionSocketFactory(builder.build(), new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.2"}, null, NoopHostnameVerifier.INSTANCE);
            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register(HTTP, new PlainConnectionSocketFactory())
                    .register(HTTPS, sslsf)
                    .build();
            cm = new PoolingHttpClientConnectionManager(registry);
            cm.setMaxTotal(200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class HttpClientPool{
        private static CloseableHttpClient httpclient = HttpClients.custom()
                .setSSLSocketFactory(sslsf)
                .setConnectionManager(cm)
                .setConnectionManagerShared(true)
                .build();
    }

    private HttpClientUtil(){

    }

    public static String doGet(String uri){
        LOG.info("doGet request:{}", uri);
        String result = null;
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpclient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .setConnectionManager(cm)
                    .setConnectionManagerShared(true)
                    .build();
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity,"UTF-8");
            LOG.info("doGet response:{}", result);
        } catch (IOException e) {
           LOG.error("doGet err, url:{}", uri, e);
        }finally {
            if(null != response){
                try {
                    response.close();
                    HttpClientPool.httpclient.close();
                } catch (IOException e) {
                    LOG.error("doGet err, url:{}", uri, e);
                }
            }
        }
        return result;
    }

    public static String post(String url, String rawJsonParam) {
        LOG.info("doPost url:{}, param:{}", url, rawJsonParam);
        String result = null;
        HttpPost httpPost = new HttpPost(url);
        StringEntity entity = new StringEntity(rawJsonParam, ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLSocketFactory(sslsf)
                    .setConnectionManager(cm)
                    .setConnectionManagerShared(true)
                    .build();
            response = httpClient.execute(httpPost);
            result = EntityUtils.toString(response.getEntity(),"UTF-8");
            LOG.info("doPost response:{}", result);
        } catch (IOException e) {
            LOG.error("doGet err, url:{}, rawJsonParam:{}", url, rawJsonParam, e);
        }finally {
            if(null != response){
                try {
                    response.close();
                    HttpClientPool.httpclient.close();
                } catch (IOException e) {
                    LOG.error("doGet err, url:{}, rawJsonParam:{}", url, rawJsonParam, e);
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
//        TemplateMsgData data = new TemplateMsgData();
//        data.setToUser("daf");
//        data.setTemplateId("1212");
//        System.out.println(JsonUtil.toJson(data));
//
//        TemplateMsgData templateMsgData = JsonUtil.toObject("{\"template_id\":\"1212\",\"touser\":\"daf\"}", new TypeReference<TemplateMsgData>(){});
//        System.out.println(templateMsgData);
//        getOpenId();
//        getUnionId();
//        sendTemplateMsg();
    }

    /**
     {
     "access_token": "14_USkz3Ho96XPcasDStIOKviTr1vS49qg6L1Juwrb1c1TE0_KJQ1LDjML1ny0Wo0IoBl6LVNquZJ9AlKvOE6Jxfmnj6629kzxmfIM6CCKd7ek",
     "expires_in": 7200,
     "refresh_token": "14_vjqFko2bMgnfVPHFFNK72PxdmCrtJ_BAZbATJWA9lcDm2XGVUNZrdjSkopxZV-B6TXCVueoou4U-oOCXFV8ir79r6rbLdr-uvCw_8umUEw8",
     "openid": "o72bZv3LU0HC-_qc6CCZp8n2EqMU",
     "scope": "snsapi_base"
     }
     */
    public static void getOpenId() {
        String baseUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
        Map<String, String> params = new HashMap<>();
        params.put("appid", "wx65b6b370eb08f5fa");
        params.put("secret", "0d7139ff0e7a7b762bec805fb2d4c13a");
        params.put("code", "02121xd72K1EIJ0hzvg72i3pd7221xds");
        params.put("grant_type", "authorization_code");
        String url = buildUrl(baseUrl, params);
        String response = doGet(url);
        System.out.println(response);
    }

    /**
     {
     "openid": "o72bZv3LU0HC-_qc6CCZp8n2EqMU",
     "nickname": "Jadic",
     "sex": 1,
     "language": "zh_CN",
     "city": "南京",
     "province": "江苏",
     "country": "中国",
     "headimgurl": "http:\/\/thirdwx.qlogo.cn\/mmopen\/vi_32\/Q0j4TwGTfTIz1cX383Wz6oBnV4ib4ty4ot0vOCGjwG0IxVaAOUmfewcYbYlOOUJ6kLXmibBjEQ8k1QA7m4S470Wg\/132",
     "privilege": [],
     "unionid": "oprWb0e5FdI8MiP_d4HKW_xFRSAE"
     }
     */
    public static void getUnionId() {
        String baseUrl = "https://api.weixin.qq.com/sns/userinfo";
        Map<String, String> params = new HashMap<>();
        params.put("access_token", "15_3QNEVBwCM0ym5Kxd4ytBQed3stVMIJ_1LHLX4FpluxxiG_73BnldmUlEKblMcHdboSDpBrbVpzs5X6LEt9ABJUNf6Mznwxjs-QAQFQWNzD7i2NER6QqQdvGUjbkZRXhACADVB");
        params.put("openid", "o72bZv249vhQvJe5WMsJO-t3T0Pg");
        params.put("lang", "zh_CN");
        String url = buildUrl(baseUrl, params);
        String response = doGet(url);
        System.out.println(response);
    }


    public static String getAccessToken(String appId, String appSecret) {
        String baseUrl = "https://api.weixin.qq.com/cgi-bin/token";
        Map<String, String> params = new HashMap<>();
        params.put("appid", appId);
        params.put("secret", appSecret);
        params.put("grant_type", "client_credential");
        String response = doGet(buildUrl(baseUrl, params));

        return response;
    }

    public static void sendTemplateMsg(TemplateMsgData templateMsgData) {
        String baseUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=15_VoAuQ7u9UIE_CcmGkvZzbJfcPfURUOIqvzv4VP0OqekqBC6pF3WUJHbKYpV122gFXezfY7qgaWC1y7XbyWgwLsikkPC11zXU-mGt6rSx3YrTzmc_Aj5bAN0FOdtLKBil5rwFa-8KNbA2QMtvQDPaAGAMZL";
        Map<String, Object> postData = new HashMap<>();
        postData.put("touser", "o72bZv249vhQvJe5WMsJO-t3T0Pg");
        postData.put("template_id", "rxjqJPbwa-pWUfE3sr4ppKpN7MBsTn1PWvjHFrxB_OE");
        //postData.put("appid", "wx95ec521df9ec5a9e");
        Map<String, Map<String, String>> templateDataMap = new HashMap<>();
        Map<String, String> firstDataMap = new HashMap<>();
        firstDataMap.put("value", "这是测试内容");
        firstDataMap.put("color", "#120FE9");
        templateDataMap.put("first", firstDataMap);
        Map<String, String> keyword1DataMap = new HashMap<>();
        keyword1DataMap.put("value", "1a2399ad");
        keyword1DataMap.put("color", "#120FE9");
        templateDataMap.put("keyword1", keyword1DataMap);
        Map<String, String> keyword2DataMap = new HashMap<>();
        keyword2DataMap.put("value", "王定喜");
        keyword2DataMap.put("color", "#120FE9");
        templateDataMap.put("keyword2", keyword2DataMap);
        Map<String, String> keyword3DataMap = new HashMap<>();
        keyword3DataMap.put("value", "10月23日 13:12");
        keyword3DataMap.put("color", "#120FE9");
        templateDataMap.put("keyword3", keyword3DataMap);
        Map<String, String> keyword4DataMap = new HashMap<>();
        keyword4DataMap.put("value", "南京->北京");
        keyword4DataMap.put("color", "#120FE9");
        templateDataMap.put("keyword4", keyword4DataMap);
        Map<String, String> keyword5DataMap = new HashMap<>();
        keyword5DataMap.put("value", "苏A 12345");
        keyword5DataMap.put("color", "#120FE9");
        templateDataMap.put("keyword5", keyword5DataMap);
        Map<String, String> remarkDataMap = new HashMap<>();
        remarkDataMap.put("value", "有问题请联系尽早联系调度员");
        remarkDataMap.put("color", "#120FE9");
        templateDataMap.put("remark", remarkDataMap);
        postData.put("data", templateDataMap);
        templateMsgData = new TemplateMsgData();
        templateMsgData.setToUser("");
        templateMsgData.setTemplateId("");
        Map<String, ValueColorPair> dataMap = new HashMap<>();
        dataMap.put("first", new ValueColorPair("", ""));
        templateMsgData.setData(null);
        String post = post(baseUrl, JsonUtil.toJson(templateMsgData));
        System.out.println(post);
    }

    public static String buildUrl(String baseUrl, Map<String, String> params) {
        List<NameValuePair> urlParams = new ArrayList<>();
        if (!CollectionUtils.isEmpty(params)) {
            for (Map.Entry<String, String> param : params.entrySet()) {
                urlParams.add(new BasicNameValuePair(param.getKey(), param.getValue()));
            }
            return baseUrl + "?" + URLEncodedUtils.format(urlParams, Consts.UTF_8);
        }
        return baseUrl;
    }
}
