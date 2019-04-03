package com.ly.demo.fallback;

import org.springframework.stereotype.Component;

import com.ly.demo.api.ConsumerAPI;

@Component
public class CommonFallback implements ConsumerAPI {

	@Override
	public String hello(String name) {
		return "server is busy, please retry after.";
	}

	@Override
	public String test() {
		return null;
	}
	
}
