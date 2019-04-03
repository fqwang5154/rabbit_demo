package com.ly.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

import com.ly.demo.filter.MyFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulConfigClient2Application {

	public static void main(String[] args) {
		SpringApplication.run(ZuulConfigClient2Application.class, args);
	}
	
	
	@ConfigurationProperties("zuul")
	@RefreshScope
	public ZuulProperties zuulProperties(){
		return new ZuulProperties();
	}

	@Bean
	MyFilter getMyFilter(){
		return new MyFilter();
	}
}
