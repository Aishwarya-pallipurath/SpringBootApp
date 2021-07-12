package com.cg.ebs.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Admin;
import com.cg.ebs.repository.AdminLoginRepository;


public class AdminLoginServiceTest {

	@MockBean
	private AdminLoginRepository adminRepository;
	
	@Autowired
	private AdminLoginService adminService;
	
	@Test
	public void testLogin() throws ResourceNotFoundException
	{
		Admin admin = new Admin();
	 	admin.setEmail("prtkshaborate@gmail.com");
	 	admin.setPassword("TjYz@895");
	 	try
	 	{
	 		Mockito.when(adminRepository.save(admin)).thenReturn(admin);
	 		assertThat(adminService.login(admin)).isEqualTo(admin);
	 	}
	 	catch(Exception e) {}
	}
	
	
	
	@Test
	public void testGetAdmin()
	{
	 	Admin admin = new Admin();
	 	admin.setEmail("prtkshaborate@gmail.com");
	 	admin.setPassword("TjYz@895");
	
	 	Admin admin1 = new Admin();
	 	admin1.setEmail("sumeete@gmail.com");
	 	admin1.setPassword("TjYz@895");
	 	try
	 	{
	 		List<Admin> adminList = new ArrayList<>();
	 		adminList.add(admin);
	 		adminList.add(admin1);
	 		Mockito.when(adminRepository.findAll()).thenReturn(adminList);
	 		assertEquals(adminService.getAdmin(),adminList);
	 	}
	 	catch(Exception e) {}
	}

	
	
	 }
