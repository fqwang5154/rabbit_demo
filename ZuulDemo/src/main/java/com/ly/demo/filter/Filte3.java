package com.ly.demo.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class Filte3 extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		String token = request.getParameter("token");
		
		if(StringUtils.isEmpty(token)){
			rc.setSendZuulResponse(false);
			rc.setResponseBody("token is null.");
			rc.setResponseStatusCode(400);
		}
		System.out.println("===============Filte3=============");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 30;
	}

	@Override
	public String filterType() {
		return "post";
	}

}
