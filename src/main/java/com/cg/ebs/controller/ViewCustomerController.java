package com.cg.ebs.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.ViewCustomer;
import com.cg.ebs.repository.ViewCustomerRepository;
import com.cg.ebs.service.ViewCustomerService;

@RestController
@RequestMapping("/api/customer")
public class ViewCustomerController {
	private static final Logger logger = LoggerFactory.getLogger(ViewCustomerController.class);

	@Autowired
	private ViewCustomerService viewCustomerService;

	@Autowired
	private ViewCustomerRepository viewCustomerRepository;

	// View All customers
	@GetMapping("/allcustomers")
	public ResponseEntity<List<ViewCustomer>> getAllCustomers() throws ResourceNotFoundException {
		logger.info("getAllCustomer() of viewCustomerController");
		List<ViewCustomer> customers = this.viewCustomerService.getAllCustomers();
		if (customers.isEmpty()) {
			throw new ResourceNotFoundException("No Customer added!");
		}

		return new ResponseEntity<List<ViewCustomer>>(customers, HttpStatus.OK);
	}


	// Get customer by email
	@GetMapping("/findbymail/{email}")
	public ResponseEntity<ViewCustomer> findByEmail(@PathVariable(value = "email") String email)
			throws ResourceNotFoundException {
		logger.info("findByEmail() of viewCustomerController");
		ViewCustomer cust = viewCustomerService.findByEmail(email);
		if (cust == null) {
			throw new ResourceNotFoundException("Customer not found for this id: " + email);
		}
		return ResponseEntity.ok().body(cust);

	}

	
}
