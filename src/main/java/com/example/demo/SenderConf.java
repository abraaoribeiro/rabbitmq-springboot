package com.example.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SenderConf {
	/*public final static String topicQueue1Name = "fanout.A";
	public final static String topicQueue2Name = "fanout.A";
	public final static String topicExchangeName = "fanout.A";*/
	
    @Bean(name="Amessage")
    public Queue AMessage() {
        return new Queue("fanout.A");
    }
	@Bean(name = "Bmessage")
	public Queue BMessage() {
		return new Queue("fanout.B");
	}

	@Bean(name = "Cmessage")
	public Queue CMessage() {
		return new Queue("fanout.C");
	}

	@Bean
	FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}
	

/*	@Bean
	public List<Declarable> topicBindings() {
		Queue topicQueue1 = new Queue(topicQueue1Name, true,false,false);

		TopicExchange topicExchange = new TopicExchange(topicExchangeName);
		return Arrays.asList(topicQueue1, topicExchange,
				BindingBuilder.bind(topicQueue1).to(topicExchange).with(topicQueue1Name));
	}*/


	@Bean
	Binding bindingExchangeA(@Qualifier("Amessage") Queue AMessage, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(AMessage).to(fanoutExchange);
	}

	@Bean
	Binding bindingExchangeB(@Qualifier("Bmessage") Queue BMessage, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(BMessage).to(fanoutExchange);
	}

	@Bean
	Binding bindingExchangeC(@Qualifier("Cmessage") Queue CMessage, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(CMessage).to(fanoutExchange);
	}

}