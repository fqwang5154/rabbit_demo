package com.ly.demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ly.demo.fallback.CommonFallback;

@FeignClient(value="api-service", fallback=CommonFallback.class)
public interface ConsumerAPI {

	@GetMapping("hello")
	@ResponseBody
	public String hello(@RequestParam("name") String name);
	
	@GetMapping("test")
	@ResponseBody
	public String test();
}
