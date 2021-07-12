package com.cg.ebs.service;


import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Admin;

public interface AdminLoginService {
	//Login
		public String login(Admin admin) throws ResourceNotFoundException;

		Iterable<Admin> getAdmin();
}
