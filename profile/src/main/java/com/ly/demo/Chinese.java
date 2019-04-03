package com.ly.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("ch")
public class Chinese implements Factor {

	@Override
	public void speak() {
		System.out.println("chinese");
	}

}
