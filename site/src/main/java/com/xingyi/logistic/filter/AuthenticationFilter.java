package com.xingyi.logistic.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xingyi.logistic.authentication.authenticator.AuthenticateChain;
import com.xingyi.logistic.authentication.authenticator.impl.LocalAuthenticator;
import com.xingyi.logistic.authentication.authenticator.impl.OAuthAuthenticator;
import com.xingyi.logistic.common.bean.JsonRet;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author tsingtao_tung
 * Created At: 2018/1/21 下午11:57.
 */
@Order(1)
@WebFilter
public class AuthenticationFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		//跨域设置
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		//这里填写你允许进行跨域的主机ip
		httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
		//允许的访问方法
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
		//Access-Control-Max-Age 用于 CORS 相关配置的缓存
		httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
		httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestURI = httpRequest.getRequestURI();
		String ctx = httpRequest.getContextPath();
		String requestPath = requestURI.replace(ctx,"");

		if(!requestPath.startsWith("/signin")){
			PrintWriter out = response.getWriter();
			//认证
			String token = httpRequest.getHeader("token");
			if(StringUtils.isBlank(token)){
				token = httpRequest.getParameter("token");
			}

			AuthenticateChain authenticateChain = new AuthenticateChain();
			authenticateChain.addAuthenticator(new LocalAuthenticator())
								.addAuthenticator(new OAuthAuthenticator());

			JsonRet<Object> jsonRet = authenticateChain.authenticate(token);
			boolean isAuthenticated = jsonRet.isSuccess();

			if(!isAuthenticated){
				out.print(JSON.toJSONString(jsonRet,SerializerFeature.WriteMapNullValue));

				out.flush();
				out.close();
			}else{
				chain.doFilter(request,response);
			}
		}else{
			chain.doFilter(request,response);
		}
	}

	@Override
	public void destroy() {

	}
}
