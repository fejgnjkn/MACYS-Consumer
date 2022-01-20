package com.zensar.services;

import java.util.List;

import com.zensar.dto.FulfillmentOrder;
import com.zensar.dto.OrderMessage;

public interface OrderMessageConsumerService {
	
	
	public List<FulfillmentOrder> getXmlMessages();
	
	public List<OrderMessage> getJsonMessages();

}
