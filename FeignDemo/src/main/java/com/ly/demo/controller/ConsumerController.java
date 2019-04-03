package com.ly.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ly.demo.api.ConsumerApi;

@RestController
public class ConsumerController {

	@Autowired
	public ConsumerApi api;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public String sayHello(){
		return api.hello("");
	}
}
