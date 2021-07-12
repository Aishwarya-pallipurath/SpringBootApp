package com.cg.ebs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.service.CustomerService;
import com.cg.ebs.model.Login;
import com.cg.ebs.repository.CustomerRepository;

import com.cg.ebs.model.Customer;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerRepository customerRepository;

	// View All customers
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() throws ResourceNotFoundException {
		logger.info("getAllCustomer() of CustomerController");
		List<Customer> customers = this.customerService.getAllCustomers();
		if (customers.isEmpty()) {
			throw new ResourceNotFoundException("No Customer added!");
		}

		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	// Customer registration
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		logger.info("addCustomer() of CustomerController");
		try {
			this.customerService.addCustomer(customer);
			// return ResponseEntity.ok().body(customer);
			return ResponseEntity.status(HttpStatus.CREATED).body(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	// Get customer by Id
	@GetMapping("customers/{id}")
	public ResponseEntity<Customer> findById(@PathVariable Integer id) throws ResourceNotFoundException {
		logger.info("findById() of CustomerController");
		Customer cust = customerService.findById(id);
		if (cust == null) {
			throw new ResourceNotFoundException("Customer not found for this id: " + id);
		}
		return ResponseEntity.ok().body(cust);

	}

	// Delete customer by id
	@DeleteMapping("customers/{id}")
	public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Integer id) {
		logger.info("deleteCustomerById() of CustomerController");
		try {

			this.customerService.deleteCustomerById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		// this.customerService.deleteCustomerById(id);

	}

	// Update profile
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer customer)
			throws ResourceNotFoundException {
		logger.info("updateCustomer() of CustomerController");
		customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + id));
		// cust.setCustomerId(customer.getCustomerId());
		Customer customer1 = customerService.updateCustomer(id, customer);

		customer1.setEmail(customer.getEmail());

		customer1.setPassword(customer.getPassword());
		customer1.setPhoneNo(customer.getPhoneNo());

		return ResponseEntity.status(HttpStatus.OK).body(customer1);

	}

	// Get customer by email
	@GetMapping("/getEmail/{email}")
	public ResponseEntity<Customer> getByEmail(@PathVariable(value = "email") String email)
			throws ResourceNotFoundException {
		logger.info("getByEmail() of CustomerController");
		Customer cust = customerService.getByEmail(email);
		if (cust == null) {
			throw new ResourceNotFoundException("Customer not found for this id: " + email);
		}
		return ResponseEntity.ok().body(cust);

	}

	// forgot password
	@PutMapping("/customers/forgotPassword")
	public String passwordChange( @RequestBody Customer customer)
			throws ResourceNotFoundException {
		logger.info("passwordChange() of CustomerController");
		String result = "";
		Customer customer1 = customerRepository.findByEmail(customer.getEmail());
		if(customer1 != null) {
		customer1.setPhoneNo(customer.getPhoneNo());
		customer1.setEmail(customer.getEmail());
		customer1.setPassword(customer.getPassword());
		customerService.forgotPassword(customer1);
		result="Password reset success";
		}
		else {
			result="User not found";
		}
		return result;
	}

	// Login
	@PostMapping("/login")
	public String login(@RequestBody Login login) throws ResourceNotFoundException {
		logger.info("login() of CustomerController");
		return customerService.login(login);
	}
	
}
