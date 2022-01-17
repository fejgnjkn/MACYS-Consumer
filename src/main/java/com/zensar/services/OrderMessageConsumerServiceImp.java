package com.zensar.services;

import java.io.IOException;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.zensar.config.OrderMessageConsumerConfig;
import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.OrderMessage;
import com.zensar.entity.FulfillmentOrderEntity;
import com.zensar.entity.OrderMessageEntity;
import com.zensar.repo.FulfillmentOrderRepo;
import com.zensar.repo.OrderMessageConsumerRepo;

@Service
public class OrderMessageConsumerServiceImp implements OrderMessageConsumerService {

	@Autowired
	OrderMessageConsumerRepo orderMessageRepo;
	
	@Autowired
	FulfillmentOrderRepo fulfillmentOrderRepo;

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Override
	public void retrieveJsonMessages() {

		OrderMessage orderMessage = null;
		Object object = this.rabbitTemplate.receiveAndConvert(OrderMessageConsumerConfig.QueueType.QUEUE_1);
		if (object instanceof OrderMessage) {
			orderMessage = (OrderMessage) object;
			System.out.println("Message received ");
		} else {
			System.out.println("Message is not available/error");
		}

		System.out.println("Json parsed successfully ");

		if (orderMessage != null) {
			OrderMessageEntity entity = generateOrderMessageEntityFromDto(orderMessage);
			orderMessageRepo.saveAndFlush(entity);
		}

	}

	private OrderMessageEntity generateOrderMessageEntityFromDto(OrderMessage orderMessage) {
		if (orderMessage == null) {
			return null;
		}

		return new OrderMessageEntity(orderMessage.getMessageName(), orderMessage.getCommand(),
				orderMessage.getItemName(), orderMessage.getItemDescription(), orderMessage.getItemLength(),
				orderMessage.getItemWidth(), orderMessage.getItemHeight(), orderMessage.getItemWeight(),
				orderMessage.getImagePathname(), orderMessage.getRfidTagged(), orderMessage.getStorageAttribute(),
				orderMessage.getPickType());

	}

	@Override
	public void retrieveXmlMessages() {
		String xmlString= null;
		Object object = this.rabbitTemplate.receiveAndConvert(OrderMessageConsumerConfig.QueueType.QUEUE_2);
		if (object instanceof String) {
			xmlString= (String)object;
		}

		FulfillmentOrder order = null;
		
		if(xmlString == null || xmlString.isEmpty()) {
			System.out.println("Xml string is null or empty");
			return;
		}

		XmlMapper mapper = new XmlMapper();
		try {
			order = mapper.readValue(xmlString.getBytes(), FulfillmentOrder.class);
		} catch (StreamReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DatabindException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Xml parsed " );
		
		if(order!=null) {
			FulfillmentOrderEntity entity= generateFulfillmentOrderEntityFromDto(order);
			this.fulfillmentOrderRepo.saveAndFlush(entity);
		}
		

	}
	
	private FulfillmentOrderEntity generateFulfillmentOrderEntityFromDto(FulfillmentOrder fulfillmentOrder) {
		if (fulfillmentOrder == null) {
			return null;
		}

		FulfillmentOrderEntity entity= new FulfillmentOrderEntity();
		entity.setFulfillmentChannelCode(fulfillmentOrder.fulfillmentChannelCode);
		return entity ;

	}

}
