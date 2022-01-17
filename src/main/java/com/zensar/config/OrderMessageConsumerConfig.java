package com.zensar.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderMessageConsumerConfig {
	public static final String ROUTING_KEY = "message_routingkey";
	public static final String QUEUE = "Message_queue";
	public static final String MESSAGE_EXCHANGE = "message_exchange";

	public static class QueueType {
		public static final String QUEUE_1 = "Message queue_1";
		public static final String QUEUE_2 = "Message queue_2";

	}

	@Bean
	public Queue queue() {
		return new Queue(QUEUE);
	}

	@Bean
	public Queue queue_1() {
		return new Queue(QueueType.QUEUE_1);
	}

	@Bean
	public Queue queue_2() {
		return new Queue(QueueType.QUEUE_2);
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(MESSAGE_EXCHANGE);
	}

//	@Bean
//	public Binding binding(Queue queue, TopicExchange topicExchange) {
//		return BindingBuilder.bind(queue).to(topicExchange).with(ROUTING_KEY);
//
//	}

	

	@Bean
	Binding binding1(TopicExchange exchange) {
		return BindingBuilder.bind(queue_1()).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	Binding binding2(TopicExchange exchange) {
		return BindingBuilder.bind(queue_2()).to(exchange).with(ROUTING_KEY);
	}

	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public AmqpTemplate template(ConnectionFactory connectionFactory) {

		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
	}

}
