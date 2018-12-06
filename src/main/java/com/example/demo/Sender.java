package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	 @Autowired
	 private FanoutExchange fanoutExchange;
	 
	public void send(String message) {
		this.rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
	}
}