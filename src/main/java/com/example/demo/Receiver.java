package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
	 protected static final String QUEUE_KEY = "hello";
	 
	 @RabbitListener(queues = "#{autoDeleteQueue1.name}")
	    public void receive1(String in) throws InterruptedException {
	       System.out.println(in);
	    }
}