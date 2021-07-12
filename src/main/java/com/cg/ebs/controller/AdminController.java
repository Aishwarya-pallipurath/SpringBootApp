package com.cg.ebs.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Admin;
import com.cg.ebs.service.AdminLoginService;
@CrossOrigin
@RestController
@RequestMapping("/cg/ebs")
public class AdminController {
	
	private static final Logger logger = LogManager.getLogger(AdminController.class);
	
	@Autowired
	private AdminLoginService loginService;
	
	@PostMapping("/admin")
	public String login(@RequestBody Admin admin)throws ResourceNotFoundException {
		
		logger.info("In admin Controller of loginAdmin ");
		logger.info("out admin Controller of loginAdmin ");
        
		
		return loginService.login(admin);
	}
	@GetMapping("/get")
	public List<Admin> getAdmin()
	{
		logger.info("In admin Controller of getAdmin");
		logger.info("out admin Controller of getAdmin");
		
		
		
		return (List<Admin>) loginService.getAdmin();
		
	}
	
}

