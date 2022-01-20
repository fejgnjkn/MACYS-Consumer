package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zensar.dto.OrderMessage;
import com.zensar.services.OrderMessageConsumerService;

@RestController
public class OrderMessageConsumerController {
	
	@Autowired
	OrderMessageConsumerService orderMessageConsumerService;
	
	@GetMapping(value="/consume/xml")
	public void retrieveXmlMessages() {
		this.orderMessageConsumerService.getXmlMessages();
	}
	
	@GetMapping(value= "/consume/json")
	public void retrieveJsonMessages() {
		this.orderMessageConsumerService.getJsonMessages();
		
	}

}
