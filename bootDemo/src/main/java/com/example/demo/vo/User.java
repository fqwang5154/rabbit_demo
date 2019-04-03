package com.example.demo.vo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="user")
public class User {

	private String title;
	
	private int age;

	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "User [title=" + title + ", age=" + age + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
