package com.ly.demo.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MyFilter extends ZuulFilter{
	
	@Value("${server.port}")
	private String port;

	@Override
	public Object run() throws ZuulException {
		System.out.println("==========================================================");
		System.out.println("网关端口号： "+port);
		System.out.println("==========================================================");
		
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		String token = request.getParameter("token");
//		if(StringUtils.isEmpty(token)){
//			rc.setSendZuulResponse(false);
//			rc.setResponseBody("token is null.");
//			rc.setResponseStatusCode(400);
//		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
