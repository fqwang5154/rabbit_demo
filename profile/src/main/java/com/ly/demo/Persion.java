package com.ly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Persion {

	@Autowired
	private Factor factor;
	
	public void speak(){
		factor.speak();
	}
}
