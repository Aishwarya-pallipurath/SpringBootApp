package com.cg.ebs.service;


import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ebs.controller.AdminController;
import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Admin;
import com.cg.ebs.repository.AdminLoginRepository;

@Service
@Transactional
public class AdminLoginServiceImpl implements AdminLoginService{

	private static final Logger logger = LogManager.getLogger(AdminController.class);
	
	@Autowired
	private AdminLoginRepository loginRepository;

	@Override
	public String login(Admin admin) throws ResourceNotFoundException {
		
		
		
		
		logger.info("in AdminLoginServiceImpl of login");
		logger.info("out AdminLoginServiceImpl of login");
		
		String result = "";
		String email = admin.getEmail();
		String password = admin.getPassword();
		Admin admin1 = loginRepository.findByEmail(email);
		if (admin1 == null) {
			result = "user does not exist";
		}

		if (admin1 != null) 
		{
			if (admin1.getPassword().equals(password)) 
			{
				result = "welcome";
			}
			else if (!admin1.getPassword().equals(password)) 
			{
				result = "please enter correct password";
			}

			else 
			{
				result = "incorrect credentials";

			}
			
		}
		

		return result;
	}
	@Override
	public Iterable<Admin> getAdmin() {
			
		logger.info("in ConsumerServiceImpl of getAllConsumer");
		logger.info("out ConsumerServiceImpl of getAllConsumer");

		
		return loginRepository.findAll();
	}

}

