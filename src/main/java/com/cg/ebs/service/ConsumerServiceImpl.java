package com.cg.ebs.service;




import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ebs.controller.ConsumerController;
import com.cg.ebs.exception.ResourceNotFoundException;
import com.cg.ebs.model.Consumer;
import com.cg.ebs.repository.ConsumerRepository;


@Service
@Transactional
public class ConsumerServiceImpl implements ConsumerService{

	private static final Logger logger = LogManager.getLogger(ConsumerController.class);
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Override
	public Iterable<Consumer> getAllConsumer() {
			
		logger.info("in ConsumerServiceImpl of getAllConsumer");
		logger.info("out ConsumerServiceImpl of getAllConsumer");

		
		return consumerRepository.findAll();
	}
	@Override
	public Consumer createConsumer(Consumer consumer)
	{
		
		logger.info("in ConsumerServiceImpl of createConsumer");
		logger.info("out ConsumerServiceImpl of createConsumer");
		
		
		return consumerRepository.save(consumer);
	}
	@Override
	public String validateConsumer(Consumer consumer) throws ResourceNotFoundException
	{	
		
		logger.info("in ConsumerServiceImpl of ValidateConsumer");
		logger.info("out ConsumerServiceImpl of ValidateConsumer");
		
		String str = "";
		long consumer_id = consumer.getConsumerId();
		String state = consumer.getState();
		String board = consumer.getBoard();
		String address = consumer.getAddress();
		Consumer consumerList = consumerRepository.findByConsumerId(consumer_id);
		
		if(consumerList==null)
		{
			str = "consumer does not exist";
		}
		if(consumerList!=null)
		{
			if(consumerList.getState().equals(state) && consumerList.getBoard().equals(board) && consumerList.getAddress().equals(address))
			{
			str = "Valid";
			}
			else if( ! consumerList.getState().equals(state) && consumerList.getBoard().equals(board) && consumerList.getAddress().equals(address))
			{
				str = "Invalid";
			}
			
			else
			{
				str = "Incorrect";
			}
		}
		return str;
		
		
	}

	@Override
	public Consumer removeConsumer(Long consumerId) throws ResourceNotFoundException {
		
		logger.info("in ConsumerServiceImpl of removeConsumer");
		logger.info("out ConsumerServiceImpl of removeConsumer");
		
		
		
		Consumer consumer = consumerRepository.findById(consumerId) .orElseThrow(() -> new ResourceNotFoundException("consumer not found for this id"));
		consumerRepository.delete(consumer);
		return consumer;
		
	}
	public Consumer findConsumerById(Long consumerId) throws ResourceNotFoundException {
		
		logger.info("in ConsumerServiceImpl of findConsumer");
		logger.info("out ConsumerServiceImpl of findConsumer");
		
		
			consumerRepository.findById(consumerId).orElseThrow(() -> new ResourceNotFoundException("consumer not found for this id " + consumerId));
			return consumerRepository.findById(consumerId).get();
		
		
	}
	@Override
	public Consumer updateConsumerById(Long consumerId, Consumer consumerDetails) {
		
		logger.info("in ConsumerServiceImpl of updateConsumer");
		logger.info("out ConsumerServiceImpl of updateConsumer");
		
		
		
		Consumer consumer = consumerRepository.findById(consumerId).get();
		consumer.setConsumerId(consumerDetails.getConsumerId());
		consumer.setState(consumerDetails.getState());
		consumer.setBoard(consumerDetails.getBoard());
		Consumer updateConsumer = consumerRepository.save(consumer);
		return updateConsumer;
		
	}
	

}
