package com.zensar.controller;


import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.zensar.services.OrderMessageConsumerService;


@SpringBootTest
@AutoConfigureMockMvc
public class OrderMessageConsumerControllerTest {
	

	@Autowired
	MockMvc mockMvc;

	@Test
	final void testRetrieveJsonMessages() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/consume/json").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	final void testRetrieveXmlMessages() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/consume/xml").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
	}
	

	
	
}
