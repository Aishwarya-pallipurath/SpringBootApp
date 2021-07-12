package com.cg.ebs.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.ebs.model.Consumer;
import com.cg.ebs.service.ConsumerService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ConsumerController.class)
public class ConsumerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ConsumerService consumerService;

	@Test
	public void testGetAllConsumer() throws Exception {
		String URI = "/cg/ebc/getAllconsumer";

		Consumer consumer1 = new Consumer();
		consumer1.setConsumerId(46577);
		consumer1.setBoard("Mahavitaran");
		consumer1.setState("Maharashtra");
		consumer1.setAddress("Pune");
		
		Consumer consumer2 = new Consumer();
		consumer2.setConsumerId(47899);
		consumer2.setBoard("Mahavitaran");
		consumer2.setState("Maharashtra");
		consumer2.setAddress("Mumbai");

		List<Consumer> consumerList = new ArrayList<>();
		consumerList.add(consumer1);
		consumerList.add(consumer2);

		
		String jsonInput = this.converttoJson(consumerList);

		Mockito.when(consumerService.getAllConsumer()).thenReturn(consumerList);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		 mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonInput);

	}
	private String converttoJson(Object consumer1) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(consumer1);
	}
	@Test
	public void testCreateConsumer() throws Exception {
		String uri = "/cg/ebs/create";
		Consumer consumer1 = new Consumer();
		consumer1.setConsumerId(46577);
		consumer1.setBoard("Mahavitaran");
		consumer1.setState("Maharashtra");
		consumer1.setAddress("Pune");
		String inputJson = mapToJson(consumer1);
		MvcResult mvcResult = mockMvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		 mvcResult.getResponse().getStatus();
		assertEquals(46577, 46577);
		MockHttpServletResponse content = mvcResult.getResponse();
		assertEquals(content, content);
	}
	String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	@Test
    public void testUpdateConsumerById() throws Exception{

		String uri = "/updateConsumerById/{consumerId}";
		Consumer consumer1 = new Consumer();
		consumer1.setConsumerId(46577);
		consumer1.setBoard("Mahavitaran");
		consumer1.setState("Maharashtra");
		consumer1.setAddress("Pune");
		
        String jsonInput = this.converttoJson(consumer1);

        Mockito.when(consumerService.updateConsumerById(Mockito.any(),Mockito.any())).thenReturn(consumer1);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(uri, "NotSchedule",201).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonOutput).isEqualTo(jsonOutput);
    }
	@Test
	public void testDeleteConsumerById() throws Exception {
		String URI = "/cg/ebs/remove/{consumerId}";

		Consumer consumer1 = new Consumer();
		consumer1.setConsumerId(46577);
		consumer1.setBoard("Mahavitaran");
		consumer1.setState("Maharashtra");
		consumer1.setAddress("Pune");
		
		Mockito.when(consumerService.findConsumerById(Mockito.any())).thenReturn(consumer1);
		Mockito.when(consumerService.removeConsumer(Mockito.any())).thenReturn(consumer1);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.delete(URI, 46577).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

	}	
	
}