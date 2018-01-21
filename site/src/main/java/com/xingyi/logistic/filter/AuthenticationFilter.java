package com.xingyi.logistic.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xingyi.logistic.authentication.authenticator.AuthenticateChain;
import com.xingyi.logistic.authentication.authenticator.impl.LocalAuthenticator;
import com.xingyi.logistic.authentication.authenticator.impl.OAuthAuthenticator;
import com.xingyi.logistic.common.bean.JsonRet;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
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
		PrintWriter writer = response.getWriter();

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestURI = httpRequest.getRequestURI();
		String ctx = httpRequest.getContextPath();
		String requestPath = requestURI.replace(ctx,"");

		if(!requestPath.startsWith("/signin") && !requestPath.startsWith("/signout") ){
			//认证
			String token = httpRequest.getParameter("token");

			AuthenticateChain authenticateChain = new AuthenticateChain();
			authenticateChain.addAuthenticator(new LocalAuthenticator())
								.addAuthenticator(new OAuthAuthenticator());

			JsonRet<Object> jsonRet = authenticateChain.authenticate(token);
			boolean isAuthenticated = jsonRet.isSuccess();

			if(!isAuthenticated){
				writer.print(JSON.toJSONString(jsonRet,SerializerFeature.WriteMapNullValue));

				writer.flush();
				writer.close();
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
