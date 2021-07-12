package com.cg.ebs.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Customer;
import com.cg.ebs.model.Login;
import com.cg.ebs.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> getAllCustomers() {

		return this.customerRepository.findAll();
	}

	@Override
	public Customer addCustomer(Customer customer) {
		logger.info("addCustomer() of CustomerServiceImpl");

		return this.customerRepository.save(customer);
	}

	@Override
	public Customer findById(Integer id) {
		logger.info("findById() of CustomerServiceImpl");

		Customer customer = null;
		Optional<Customer> cust = this.customerRepository.findById(id);
		if (cust.isPresent()) {
			customer = cust.get();
		}
		return customer;
	}

	@Override
	public void deleteCustomerById(Integer id) {
		logger.info("deleteCustomerById() of CustomerServiceImpl");
		this.customerRepository.deleteById(id);

	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) {
		logger.info("updateCustomer() of CustomerServiceImpl");
		customer.setId(id);
		return customerRepository.save(customer);
	}

	@Override
	public Customer getByEmail(String email) {
		logger.info("getByEmail() of CustomerServiceImpl");
		return customerRepository.findByEmail(email);
	}

	@Override
	public void forgotPassword( Customer customer) {
		logger.info("forgotPassword() of CustomerServiceImpl");
		customerRepository.save(customer);
	}

	@Override
	public String login(Login login) throws ResourceNotFoundException {
		logger.info("login() of CustomerServiceImpl");
		String result = "";
		String email = login.getEmail();
		String password = login.getPassword();
		Customer customer = customerRepository.findByEmail(email);
		if (customer == null) {
			result = "user does not exist";
		}

		if (customer != null) {
			if (customer.getPassword().equals(password)) {
				result = "welcome";
			} else if (!customer.getPassword().equals(password)) {
				result = "please enter correct password";
			}

			else {
				result = "incorrect credentials";

			}

		}

		return result;
	}



}
