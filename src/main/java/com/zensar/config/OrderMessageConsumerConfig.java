package com.zensar.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.Jackson2XmlMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class OrderMessageConsumerConfig {

	public static final String ROUTING_KEY_JSON = "routing_key_json";
	public static final String ROUTING_KEY_XML = "routing_key_xml";
	public static final String MESSAGE_EXCHANGE = "message_exchange";

	public static class QueueType {
		public static final String XML_QUEUE = "XML_QUEUE";
		public static final String JSON_QUEUE = "JSON_QUEUE";

	}

	@Autowired
	private ConnectionFactory connectionFactory;

	@Bean
	public Queue queue_json() {
		return new Queue(QueueType.JSON_QUEUE, true);
	}

	@Bean
	public Queue queue_xml() {
		return new Queue(QueueType.XML_QUEUE, true);
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(MESSAGE_EXCHANGE);
	}

	@Bean
	public Binding bindingJson(TopicExchange exchange) {

		return BindingBuilder.bind(queue_json()).to(exchange).with(ROUTING_KEY_JSON);
	}

	@Bean
	public Binding bindingXml(TopicExchange exchange) {

		return BindingBuilder.bind(queue_xml()).to(exchange).with(ROUTING_KEY_XML);
	}

	@Bean
	public MessageConverter messageConverterJson() {
		ObjectMapper objectMapper = new ObjectMapper();
		return new Jackson2JsonMessageConverter(objectMapper);
	}

	@Bean
	public MessageConverter messageConverterXml() {
		return new Jackson2XmlMessageConverter();
	}

	@Bean
	public AmqpTemplate jsontemplate(ConnectionFactory connectionFactory) {

		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverterJson());
		rabbitTemplate.setDefaultReceiveQueue(QueueType.JSON_QUEUE);
		rabbitTemplate.setRoutingKey(ROUTING_KEY_JSON);
		return rabbitTemplate;
	}

	@Bean
	public AmqpTemplate xmlAmpqTempleate(ConnectionFactory connectionFactory) {

		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverterXml());
		rabbitTemplate.setDefaultReceiveQueue(QueueType.XML_QUEUE);
		rabbitTemplate.setRoutingKey(ROUTING_KEY_XML);
		return rabbitTemplate;
	}

	@Bean
	public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
