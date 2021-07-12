package com.cg.ebs.service;

import java.util.List;

import com.cg.ebs.model.Customer;
import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Login;

public interface CustomerService {
	// View All Customers
	public List<Customer> getAllCustomers();

	// Create new Customer
	public Customer addCustomer(Customer customer);

	// Find customer by id
	public Customer findById(Integer id);

	// delete customer by id
	public void deleteCustomerById(Integer id);

	// update customer by id
	public Customer updateCustomer(Integer id, Customer customer);

	// get customer by email
	public Customer getByEmail(String email);

	// Forgot password
	public void forgotPassword(Customer customer);
	
	
	//Login
	public String login(Login login) throws ResourceNotFoundException;
	
	

}
