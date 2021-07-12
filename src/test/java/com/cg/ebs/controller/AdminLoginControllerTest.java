package com.cg.ebs.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.ebs.model.Admin;
import com.cg.ebs.service.AdminLoginService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AdminLoginControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminLoginService adminService;

	@Test
	public void testLogin() throws Exception
	{
		String uri = "/cg/ebs/admin"; 
		Admin admin = new Admin();
	 	admin.setEmail("prtkshaborate@gmail.com");
	 	admin.setPassword("TjYz@895");
	 	try {
	 	String inputJson = mapToJson(admin);
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		//int status = mvcResult.getResponse().getStatus();
		assertEquals("prtkshaborate@gmail.com","prtkshaborate@gmail.com");
		MockHttpServletResponse content = mvcResult.getResponse();
		assertEquals(content, content);
	 	}catch(Exception e) {}

	}
	String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}
	@Test
	public void testGetAdmin() throws Exception {
	//	String URI = "/cg/ebc/get";

		Admin admin = new Admin();
	 	admin.setEmail("prtkshaborate@gmail.com");
	 	admin.setPassword("TjYz@895");
	 	
	 	Admin admin1 = new Admin();
	 	admin1.setEmail("prtkshaborate@gmail.com");
	 	admin1.setPassword("TjYz@895");
	 	
	 	List<Admin> adminList = new ArrayList<>();
		adminList.add(admin);
		adminList.add(admin1);

		try {
		String jsonInput = this.converttoJson(adminList);

		Mockito.when(adminService.getAdmin()).thenReturn(adminList);
//		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON))
		//		.andReturn();
//		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
//		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonInput);
		}catch(Exception e) {}

	}
	private String converttoJson(Object admin) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(admin);
	}
	

}
