package com.ly.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class PRabbitMqApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		Connection con=CommonUtils.getConnection();
		Channel channel = con.createChannel();
		channel.queueDeclare("test", false, false, false, null);
		channel.basicPublish("", "test", null, "hello world".getBytes());
		channel.close();
		con.close();
	}

}
