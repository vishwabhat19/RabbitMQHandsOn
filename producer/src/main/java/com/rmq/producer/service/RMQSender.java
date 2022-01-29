package com.rmq.producer.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.rmq.producer.model.Employee;

@Service
public class RMQSender {
	
	@Autowired
	private AmqpTemplate rmqTemplate;
	
	@Value("${rabbitmq.exchange}")
	private String exchange;
	
	@Value("${rabbitmq.routingkey}")
	private String routingKey;
	
	public void send(Employee e) {
		
		rmqTemplate.convertAndSend(exchange, routingKey, e);
		System.out.println("Sent to Rabbit Mq -" + e);
	}

}
