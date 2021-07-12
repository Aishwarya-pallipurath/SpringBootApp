package com.cg.ebs.service;

import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Supervisor;

public interface SupervisorService {
	
	//Login
			public String login(Supervisor supervisor) throws ResourceNotFoundException;

			public void forgotPassword(Supervisor supervisor) throws ResourceNotFoundException;

}
