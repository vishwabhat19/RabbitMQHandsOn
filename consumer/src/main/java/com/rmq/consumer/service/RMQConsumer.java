package com.rmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rmq.consumer.model.Employee;

@Component
public class RMQConsumer {
	
	@RabbitListener(queues = "${rabbitmq.queue}")
	public void recievedMessage(Employee emp) {
		
		System.out.println("Message Recieved from q1- "+emp);
	}
	
	

	
}
