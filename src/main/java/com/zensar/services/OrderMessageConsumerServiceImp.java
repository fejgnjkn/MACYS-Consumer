package com.zensar.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
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
import com.zensar.config.OrderMessageConsumerConfig.QueueType;
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
	AmqpTemplate xmlAmpqTempleate;

	@Autowired
	AmqpTemplate jsontemplate;

	@Autowired
	RabbitAdmin rabbitAdmin;

	@Autowired
	ModelMapper modelMapper;

	private OrderMessageEntity generateOrderMessageEntityFromDto(OrderMessage orderMessage) {
		if (orderMessage == null) {
			return null;
		}
		OrderMessageEntity orderMessageEntity = this.modelMapper.map(orderMessage, OrderMessageEntity.class);
		return orderMessageEntity;
	}

	private OrderMessage generateOrderMessageDtoFromEntity(OrderMessageEntity orderEntity) {
		if (orderEntity == null) {
			return null;
		}
		OrderMessage orderMessage = this.modelMapper.map(orderEntity, OrderMessage.class);
		return orderMessage;
	}

	@Override
	public List<FulfillmentOrder> getXmlMessages() {

		List<FulfillmentOrder> fullFulfillmentOrders = new ArrayList<>();
		Properties properties = rabbitAdmin.getQueueProperties(OrderMessageConsumerConfig.QueueType.XML_QUEUE);
		int requestCount = 0;
		if (properties != null) {
			requestCount = (int) properties.get(RabbitAdmin.QUEUE_MESSAGE_COUNT);
		}

		for (int i = 0; i < requestCount; i++) {
			try {

				FulfillmentOrder fulfillmentOrder = new XmlMapper()
						.readValue(new String((byte[]) xmlAmpqTempleate.receiveAndConvert()), FulfillmentOrder.class);

				if (fulfillmentOrder != null) {

					FulfillmentOrderEntity fulfillmentOrderEntity = convertFulfillmentorderIntoFulfillmentorderEntity(
							fulfillmentOrder);
					fulfillmentOrderRepo.saveAndFlush(fulfillmentOrderEntity);
					fullFulfillmentOrders.add(fulfillmentOrder);

				} else {
					System.out.println("Saving xml data to db failed");
				}

			} catch (Exception e) {
				break;
			}
		}
		return fullFulfillmentOrders;
	}

	public String cleanUpJsonBOM(String json) {
		return json.trim().replaceFirst("\ufeff", "");
	}

	@Override
	public List<OrderMessage> getJsonMessages() {
		List<OrderMessage> orderMessages = new ArrayList<>();
		Properties properties = rabbitAdmin.getQueueProperties(OrderMessageConsumerConfig.QueueType.JSON_QUEUE);
		int requestCount = 0;
		if (properties != null) {
			requestCount = (int) properties.get(RabbitAdmin.QUEUE_MESSAGE_COUNT);
		}

		for (int i = 0; i < requestCount; i++) {

			try {
				
				String jsonString =new String((byte[]) jsontemplate.receiveAndConvert(QueueType.JSON_QUEUE));
				jsonString =cleanUpJsonBOM(jsonString);
				OrderMessage orderMessage = new ObjectMapper().readValue(jsonString
						, OrderMessage.class);
				System.out.println("json string is : " + orderMessage.toString());
//				OrderMessage orderMessage =  (OrderMessage) jsontemplate.receiveAndConvert(QueueType.JSON_QUEUE);
				OrderMessageEntity orderEntity = generateOrderMessageEntityFromDto(orderMessage);
				OrderMessageEntity effectedEntity = null;

				try {

					effectedEntity = orderMessageRepo.save(orderEntity);
					orderMessages.add(generateOrderMessageDtoFromEntity(orderEntity));

				} catch (Exception e) {
					e.printStackTrace();
					break;
				} finally {
					if (effectedEntity == null) {
						System.out.println("Save Jason data to db failed");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Save Jason data to db failed");
			}
		}

		return orderMessages;
	}

	public FulfillmentOrderEntity convertFulfillmentorderIntoFulfillmentorderEntity(FulfillmentOrder order) {
		FulfillmentOrderEntity fulfillmentOrderEntity = new FulfillmentOrderEntity();

		fulfillmentOrderEntity.orderID = order.orderID;
		fulfillmentOrderEntity.orderStatus = order.orderStatus;
		fulfillmentOrderEntity.orderStatusCode = order.orderStatusCode;
		fulfillmentOrderEntity.orderStatusDescription = order.orderStatusDescription;
		fulfillmentOrderEntity.orderTypeCode = order.orderTypeCode;
		return fulfillmentOrderEntity;
	}

}
