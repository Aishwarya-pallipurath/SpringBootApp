package com.cg.ebs.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

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

import com.cg.ebs.model.Customer;
import com.cg.ebs.repository.CustomerRepository;
import com.cg.ebs.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(value=CustomerController.class)
public class CustomerControllerTest {
	@Autowired
	MockMvc mockMvc;
	
    @MockBean
    private CustomerService customerService;
    
    @MockBean
    private CustomerRepository customerRepository;

@Test
public void testGetAllCustomers() throws Exception {
	String URI="/api/v1/customers";
	Customer customer1 = new Customer();
	customer1.setEmail("aishwaryap@gmail.com");
	customer1.setPassword("password12");
	customer1.setPhoneNo("987654321");

	Customer customer2 = new Customer();
	customer2.setEmail("ragina@gmil.com");
	customer2.setPassword("phalange");
	customer2.setPhoneNo("9998887774");
	List<Customer> customerList=new ArrayList<>();
	customerList.add(customer1);
	customerList.add(customer2);
String jsonInput=converttoJson(customerList);
	
	Mockito.when(customerService.getAllCustomers()).thenReturn(customerList);
    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
    MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
    String jsonOutput = mockHttpServletResponse.getContentAsString();
    assertEquals(jsonInput, jsonOutput);
}
@Test
public void testAddCustomer() throws Exception{
	String URI="/api/v1/customers";
	Customer customer1=new Customer();
	customer1.setId(72);
	customer1.setEmail("aishwaryap@gmail.com");
	customer1.setPassword("password12");
	customer1.setPhoneNo("987654321");
	String jsonInput=this.converttoJson(customer1);
	Mockito.when(customerService.addCustomer(Mockito.any(Customer.class))).thenReturn(customer1);
	MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
			.content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
	MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
	String jsonOutput=mockHttpServletResponse.getContentAsString();
	assertThat(jsonInput).isEqualTo(jsonOutput);
	Assert.assertEquals(HttpStatus.CREATED.value(), mockHttpServletResponse.getStatus());
}
@Test
public void testFindById() throws Exception{
	String URI="/api/v1/customers/{id}";
	Customer customer1=new Customer();
	customer1.setId(72);
	customer1.setEmail("aishwaryap@gmail.com");
	customer1.setPassword("password12");
	customer1.setPhoneNo("987654321");
	String jsonInput=this.converttoJson(customer1);
	Mockito.when(customerService.findById(Mockito.any())).thenReturn(customer1);
	MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI,customer1.getId()).
			accept(MediaType.APPLICATION_JSON)).andReturn();
	MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
	String jsonOutput=mockHttpServletResponse.getContentAsString();
	assertThat(jsonInput).isEqualTo(jsonOutput);
	Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
}
@Test
public void testDeleteCustomerById() throws Exception {
	String URI="/api/v1/customers/{id}";
	Customer customer1=new Customer();
	customer1.setId(72);
	customer1.setEmail("aishwaryap@gmail.com");
	customer1.setPassword("password12");
	customer1.setPhoneNo("987654321");
    customerService.deleteCustomerById(70);
    MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.delete(URI,70).accept(MediaType.APPLICATION_JSON)).andReturn();
	MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
	
	Assert.assertEquals(HttpStatus.NO_CONTENT.value(), mockHttpServletResponse.getStatus());
}
private String converttoJson(Object customer) throws JsonProcessingException{
	ObjectMapper objectMapper=new ObjectMapper();
	return objectMapper.writeValueAsString(customer);
}

}
