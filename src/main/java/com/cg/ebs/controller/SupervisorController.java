package com.cg.ebs.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Supervisor;
import com.cg.ebs.repository.SupervisorRepository;
import com.cg.ebs.service.SupervisorService;
@CrossOrigin
@RestController
@RequestMapping("/api/supervisor")
public class SupervisorController {
	
    //api-docs
//swagger-ui.html

	
//	private static Logger log = Logger.getLogger(SupervisorController. class);


	@Autowired
	private SupervisorRepository supervisorRepository;
	@Autowired
	private SupervisorService supervisorService;
	
	@PutMapping("/resetpwd/{email}")
	public String forgetPassword(@RequestBody Supervisor supervisor) throws ResourceNotFoundException {
		// log.info("passwordChange() of supervisorController");
		 String result = "";
		 Supervisor supervisor1 = supervisorRepository.findByEmail(supervisor.getEmail());
			if(supervisor1 != null) {
				supervisor1.setEmail(supervisor.getEmail());
				supervisor1.setPassword(supervisor.getPassword());
				supervisorService.forgotPassword(supervisor1);
				result="Password reset success";
			}
			else {
				result="User not found";
			}
			return result;
		}
	
	
	@PostMapping("/login")
	public String login(@RequestBody Supervisor supervisor)throws ResourceNotFoundException {
		//log.info("login() of SupervisorController");
		return supervisorService.login(supervisor);
	}
}
