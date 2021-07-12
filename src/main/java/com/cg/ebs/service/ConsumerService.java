package com.cg.ebs.service;



import com.cg.ebs.exception.*;


import com.cg.ebs.model.*;

public interface ConsumerService {
	
	Iterable<Consumer> getAllConsumer();
	
	public Consumer createConsumer(Consumer consumer);
	 
	Consumer removeConsumer(Long consumerId) throws ResourceNotFoundException;
	 
 	public Consumer findConsumerById(Long consumerId) throws ResourceNotFoundException;
	 
 	public String validateConsumer(Consumer consumer) throws ResourceNotFoundException;  
 	
	Consumer updateConsumerById(Long consumerId,Consumer consumerDetails);
	 	
}
