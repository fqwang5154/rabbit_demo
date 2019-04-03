package com.ly.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value="hello", method=RequestMethod.GET)
	@ResponseBody
	public String hello(String name){
		System.out.println("retry....");
		try{
			Thread.sleep(1500);
		}catch(Exception e){
			
		}
		return "hello "+port;
	}
	
	@GetMapping("test")
	@ResponseBody
	public String test(){
		return "hello spring-cloud.";
	}
	
}
