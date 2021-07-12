package com.cg.ebs.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.*;
import com.cg.ebs.service.ConsumerService;

@RestController
@CrossOrigin
@RequestMapping("cg/ebs")
public class ConsumerController {
	
	private static final Logger logger = LogManager.getLogger(ConsumerController.class);
	
	@Autowired
	private ConsumerService consumerService;
	
	@GetMapping("/getAllConsumer")
	public List<Consumer> getAllConsumer()
	{
		logger.info("In consumer Controller of getAllConsumer");
		logger.info("out consumer Controller of getAllConsumer");
		
		
		return (List<Consumer>) consumerService.getAllConsumer();
		
	}
	@PostMapping("/consumer")
	public String manageConsumer(@RequestBody Consumer consumer)throws ResourceNotFoundException
	{
		return consumerService.validateConsumer(consumer);
	}
	/*{
    "consumerId":4444989991,
    "state":"maharashtra",
    "board":"maharashtra",
    "address":"Pune"
}*/
	@PostMapping("/create")
	public Consumer createConsumer(@RequestBody Consumer consumer)throws ResourceNotFoundException
	{
		logger.info("In consumer Controller of createConsumer ");
		logger.info("out consumer Controller of createConsumer ");
        
		return consumerService.createConsumer(consumer);
	}
	@DeleteMapping("/remove/{consumerId}")
	public String deleteConsumerById(@PathVariable Long consumerId) throws ResourceNotFoundException
	{
		logger.info("In consumer Controller of deleteConsumer ");
		logger.info("out consumer Controller of deleteConsumer ");
        
		consumerService.removeConsumer(consumerId);
		return consumerId+"consumerId deleted Successfully";
	}
	@GetMapping("/getConsumerById/{consumerId}")
	public Consumer getConsumerById(@PathVariable Long consumerId) throws ResourceNotFoundException
	{
		logger.info("In consumer Controller of getConsumer ");
		logger.info("out consumer Controller of getConsumer ");
        
		return (consumerService.findConsumerById(consumerId));
	}
	@PutMapping("/updateConsumerById/{consumerId}")
	public Consumer updateConsumerById(@PathVariable Long consumerId,@RequestBody Consumer consumerDetails) throws ResourceNotFoundException 
	{
		logger.info("In consumer Controller of updateConsumer ");
		logger.info("out consumer Controller of updateConsumer ");
        
		
		return consumerService.updateConsumerById(consumerId, consumerDetails);
		
	}
}
