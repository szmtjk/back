package com.szmtjk.web.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.szmtjk.authentication.authenticator.AuthenticateChainFactory;
import com.szmtjk.authentication.util.UserSessionUtil;
import com.xxx.common.bean.JsonRet;
import org.springframework.core.annotation.Order;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午11:57.
 */
@Order(1)
@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

	public static boolean isEnabled = true;

	private static final List<String> URL_WHITE_LIST = Lists.newArrayList(
			"/test/", "/webjars", "/api", "/swagger-ui.html", "/swagger-resources",
			"/v2/api-docs", "/wechat/", "/mobile/", "/signin/"
	);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter is inited");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (!isEnabled) {
			chain.doFilter(request,response);
			return;
		}
		response.setCharacterEncoding("UTF-8");

		//跨域设置
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		//这里填写你允许进行跨域的主机ip
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		//允许的访问方法
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
		//Access-Control-Max-Age 用于 CORS 相关配置的缓存
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, token");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestURI = httpRequest.getRequestURI();
		String ctx = httpRequest.getContextPath();
		String requestPath = requestURI.replace(ctx,"");

		if (!isRequestStartsWithInWhitelist(requestPath)) {// 非白名单的进行token验证
			String token = httpRequest.getHeader("token");
			JsonRet<Object> ret = AuthenticateChainFactory.authenticate(token);
			boolean isAuthenticated = ret.isSuccess();
			if(!isAuthenticated){
				PrintWriter out = response.getWriter();
				out.print(JSON.toJSONString(ret,SerializerFeature.WriteMapNullValue));
				out.flush();
				out.close();
				return;
			}
		}
		try {
			chain.doFilter(request, response);
		} finally {
			UserSessionUtil.removeCurrentUser();
		}
	}

	private boolean isRequestStartsWithInWhitelist(String requestPath) {
		for (String url : URL_WHITE_LIST) {
			if (requestPath.startsWith(url)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy() {

	}
}
