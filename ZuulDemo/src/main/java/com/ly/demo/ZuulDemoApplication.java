package com.ly.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.ly.demo.filter.Filte2;
import com.ly.demo.filter.Filte3;
import com.ly.demo.filter.MyFilter;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulDemoApplication.class, args);
	}
	
	@Bean
	MyFilter getMyFilter(){
		return new MyFilter();
	}
	@Bean
	Filte2 Filte2(){
		return new Filte2();
	}
	@Bean
	Filte3 Filte3(){
		return new Filte3();
	}
//	
//	@ConfigurationProperties("zuul")
//	ZuulProperties zuulProperties(){
//		return new ZuulProperties();
//	}

}
