package com.cg.ebs.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ebs.model.Customer;
import com.cg.ebs.repository.CustomerRepository;
import com.cg.ebs.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;
	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void testGetAllCustomers() {
		
		Customer customer1 = new Customer();
		customer1.setEmail("aishwaryap@gmail.com");
		customer1.setPassword("password12");
		customer1.setPhoneNo("987654321");

		Customer customer2 = new Customer();
		customer2.setEmail("ragina@gmil.com");
		customer2.setPassword("phalange");
		customer2.setPhoneNo("9998887774");

		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		Mockito.when(customerRepository.findAll()).thenReturn(customerList);
		assertThat(customerService.getAllCustomers()).isEqualTo(customerList);
	}

	@Test
	public void testFindById() {

		Optional<Customer> customer = Optional
				.of(new Customer(71, "7798887774", "aishwaryap@gmail.com", "password12"));
		when(customerRepository.findById(71)).thenReturn(customer);
		Customer cust = customerService.findById(71);
		assertEquals("7798887774", cust.getPhoneNo());
		assertEquals("password12", cust.getPassword());
		assertEquals("aishwaryap@gmail.com", cust.getEmail());
	}

	@Test
	public void testAddCustomer() {
		Customer customers = new Customer(72, "987654123", "aishwaryap@gmail.com", "password12");
		Customer cust = customerRepository.save(customers);
		System.out.println(cust);
		Mockito.when(customerService.addCustomer(customers)).thenReturn(customers);
		// assertEquals(customerService.addCustomer(customers), customers);
	}

	@Test
	public void testUpdateCustomer() {

		Customer customer1 = new Customer();
		customer1.setEmail("aishwaryap@gmail.com");
		customer1.setPassword("password12");
		customer1.setPhoneNo("987654321");
		
		Mockito.when(customerRepository.save(customer1)).thenReturn(customer1);
		customer1.setEmail("himanshi@yahoo.com");
		Mockito.when(customerService.updateCustomer(customer1.getId(), customer1)).thenReturn(customer1);
		assertEquals(customer1.getEmail(), "himanshi@yahoo.com");

	}

	@Test
	public void testDeleteCustomerById() throws Exception {

		Customer customer1 = new Customer();
		customer1.setEmail("aishwaryap@gmail.com");
		customer1.setPassword("password12");
		customer1.setPhoneNo("987654321");

		Customer customer2 = new Customer();
		customer2.setEmail("ragina@gmil.com");
		customer2.setPassword("phalange");
		customer2.setPhoneNo("9998887774");

		List<Customer> clist = new ArrayList<>();
		clist.add(customer1);
		Mockito.when(customerService.addCustomer(customer1)).thenReturn(customer1);
		Mockito.when(customerService.addCustomer(customer2)).thenReturn(customer2);
		Mockito.when(customerService.getAllCustomers()).thenReturn(clist);
		customerService.deleteCustomerById(customer1.getId());
		System.out.println(clist.size());
		assertEquals(clist.size(), customerService.getAllCustomers().size());

	}
}
