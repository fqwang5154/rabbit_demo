package com.ly.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Consumer {
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private DiscoveryClient dc;
	
	
	private int resCount=1;
	
	@RequestMapping(value="consumer", method=RequestMethod.GET)
	@ResponseBody
	public String consumer(){
		resCount++;
		//如果使用rest方式以别名进行调用，必须依赖ribbon负载均衡器@LoadBalanced
		//@LoadBalanced能让rest进行请求时拥有客户端负载均衡的能力
//		String url="http://API-SERVICE/hello";
//		String result=rest.getForObject(url, String.class);
//		return result;
		List<ServiceInstance> instances=dc.getInstances("API-SERVICE");
		if(instances==null || instances.size()==0){
			return "empty";
		}
		
		System.out.println(instances.get(resCount % instances.size()).getUri()+"/hello");
		String url=instances.get(resCount % instances.size()).getUri().toString()+"/hello";
		String result=rest.getForObject(url, String.class);
		return result;
	}
	
	
	@GetMapping("getConsumer")
	@ResponseBody
	public String getConsumer(){
		return "我是一个消费者";
	}
}
