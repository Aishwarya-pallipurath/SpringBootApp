package com.cg.ebs.service;

import java.util.List;

import com.cg.ebs.model.ViewCustomer;
public interface ViewCustomerService {
	
	// View All Customers
	public List<ViewCustomer> getAllCustomers() ;

	// get customer by email
	public ViewCustomer findByEmail(String email);
	

}
