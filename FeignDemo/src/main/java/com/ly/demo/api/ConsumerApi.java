package com.ly.demo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value="api-service")
public interface ConsumerApi {
	
	@RequestMapping(value="hello", method=RequestMethod.GET)
	@ResponseBody
	public String hello(@RequestParam("name") String name);

}
