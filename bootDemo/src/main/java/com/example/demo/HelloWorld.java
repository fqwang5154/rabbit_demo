package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.User;

@RestController
public class HelloWorld {
	
	@Autowired
	private User user;

	@RequestMapping(value="hello/{name}/{desc}", method=RequestMethod.GET)
	public String hello(@PathVariable("name") String name, @PathVariable("desc") String desc){
		
		System.out.println(user);    
		
		return "hello "+name+'\t'+desc;
	}
}
