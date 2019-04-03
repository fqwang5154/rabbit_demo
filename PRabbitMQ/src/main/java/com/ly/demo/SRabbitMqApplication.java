package com.ly.demo;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.AMQP.BasicProperties;

public class SRabbitMqApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		Connection con=CommonUtils.getConnection();
		Channel channel = con.createChannel();
		
		channel.queueDeclare("test", false, false, false, null);
		DefaultConsumer consumer=new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties, byte[] body)
					throws IOException {
				// TODO Auto-generated method stub
				super.handleDelivery(consumerTag, envelope, properties, body);
				String msg=new String(body, "utf-8");
				System.out.println("consumer: "+msg);
			}
		};
		channel.basicConsume("test", true, consumer);
//		channel.basicPublish("", "test", null, "hello world".getBytes());
		
//		channel.close();
//		con.close();
	}

}
