package com.ly.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfigClientController {

	@Value("${desc}")
	private String desc;
	
	@GetMapping("getDesc")
	@ResponseBody
	public String getDesc(){
		
		return desc;
	}
}
