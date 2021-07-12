package com.cg.ebs.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Supervisor;
import com.cg.ebs.repository.SupervisorRepository;

@Service
public class SupervisorserviceImpl implements SupervisorService {
	
	@Autowired
	private SupervisorRepository supervisorRepository;


	@Override
	public String login(Supervisor supervisor) throws ResourceNotFoundException {
		String result = "";
		String email = supervisor.getEmail();
		String password = supervisor.getPassword();
		Supervisor supervisors = supervisorRepository.findByEmail(email);
		
		if (supervisors == null) 
		{
		  result ="Supervisor does not exist...Please check the Supervisor Email ID";
		}
		
		if (supervisors != null) {
			if ((supervisors.getPassword().equals(password)) && (supervisors.getEmail().equals(email))) {
				result = "Supervisor Logged In Successfully";
			}
			else if ((!supervisors.getPassword().equals(password))&& (supervisors.getEmail().equals(email)))
			{
				result = "Please enter correct password";
			}
		
		}
		
		return result;
	}

	

	@Override
	public void forgotPassword(Supervisor supervisor) throws ResourceNotFoundException {
		
		supervisorRepository.save(supervisor);
	}

}
