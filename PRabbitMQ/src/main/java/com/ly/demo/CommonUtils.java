package com.ly.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class CommonUtils {

	public static Connection getConnection() throws IOException, TimeoutException{
		ConnectionFactory factory= new ConnectionFactory();
		
		factory.setHost("192.168.43.204");
		
		factory.setPort(5672);
		
		factory.setVirtualHost("/vhost_ly");
		
		factory.setUsername("ly");
		
		factory.setPassword("Pass8183");
		
		return factory.newConnection();
	}
}
