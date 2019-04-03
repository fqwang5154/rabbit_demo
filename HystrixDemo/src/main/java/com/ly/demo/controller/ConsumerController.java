package com.ly.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ly.demo.api.ConsumerAPI;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ConsumerController {

	@Autowired
	private ConsumerAPI api;
	
//	@HystrixCommand(fallbackMethod="tip")
	@GetMapping("hello")
	@ResponseBody
	public String hello(){
		System.out.println("hello:thread_name="+Thread.currentThread().getName());//hello:thread_name=hystrix-ConsumerController-1
		return api.hello("");
	}
	
	private String tip(){
		System.out.println("================服务器繁忙，请稍后重试=================");
		return "服务器繁忙，请稍后重试";
	}
	
	@GetMapping("test")
	@ResponseBody
	public String test(){
		System.out.println("test:thread_name="+Thread.currentThread().getName());//test:thread_name=http-nio-8500-exec-9
		return api.test();
	}
}
