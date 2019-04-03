package com.ly.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("en")
public class English implements Factor {

	@Override
	public void speak() {
		System.out.println("english");
	}

}
