package com.cg.ebs.service;

import java.util.ArrayList;


import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.ebs.model.*;
import com.cg.ebs.repository.*;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerServiceTest {

	@MockBean
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private ConsumerService consumerService;
	
	
	
	@Test
	public void testGetAllConsumer()
	{
		Consumer consumer1 = new Consumer();
		consumer1.setConsumerId(46577);
		consumer1.setBoard("Mahavitaran");
		consumer1.setState("Maharashtra");
		consumer1.setAddress("Pune");
		
		Consumer consumer2 = new Consumer();
		consumer2.setConsumerId(47899);
		consumer2.setBoard("Mahavitaran");
		consumer2.setState("Maharashtra");
		consumer2.setAddress("Mumbai");

		List<Consumer> consumerList = new ArrayList<>();
		consumerList.add(consumer1);
		consumerList.add(consumer2);
		Mockito.when(consumerRepository.findAll()).thenReturn(consumerList);
		assertEquals(consumerService.getAllConsumer(),consumerList);
		
	}
	
	  @Test public void testCreateConsumer() 
	  { 
		  Consumer consumer1 = new Consumer();
		  consumer1.setConsumerId(46577); 
		  consumer1.setBoard("Mahavitaran");
		  consumer1.setState("Maharashtra"); 
		  consumer1.setAddress("Pune");
	  
		  Mockito.when(consumerRepository.save(consumer1)).thenReturn(consumer1);
		  assertThat(consumerService.createConsumer(consumer1)).isEqualTo(consumer1);
	  
	  }
	  @Test
		public void testFindConsumerById()
		{
		  	Consumer consumer = new Consumer();
			consumer.setConsumerId(47899); 
			consumer.setBoard("Mahavitaran");
			consumer.setState("Maharashtra"); 
			consumer.setAddress("Mumbai");
			
			try
			{
			Consumer ap = consumerRepository.findById((long) 47899).get();
			Mockito.when(ap).thenReturn(consumer);
			assertThat(consumerService.findConsumerById((long) 47899)).isEqualTo(consumer);
			}
			catch(Exception e) {}
		}
	  @Test
		public void testRemoveConsumer()
		{
		  	Consumer consumer = new Consumer();
			consumer.setConsumerId(47899); 
			consumer.setBoard("Mahavitaran");
			consumer.setState("Maharashtra"); 
			consumer.setAddress("Mumbai");
			
			try
			{
				Mockito.when(consumerRepository.save(consumer)).thenReturn(consumer);
				Mockito.when(consumerRepository.findById((long) 2).get()).thenReturn(consumer);
				consumerRepository.deleteById(consumer.getConsumerId());
				Mockito.when(consumerRepository.findById((long) 2).get()).thenReturn(consumer);
				Assert.assertEquals(consumerService.removeConsumer((long) 2), false);
			}
			catch(Exception e) {}
		}
	  @Test
		public void updateAppointmentById()
		{
		  	Consumer consumer = new Consumer();
			consumer.setConsumerId(101); 
			consumer.setBoard("Mahavitaran");
			consumer.setState("Maharashtra"); 
			consumer.setAddress("Mumbai");
			
		 	try
			{
				Mockito.when(consumerRepository.findById((long) 101).get()).thenReturn(consumer);
				consumer.setAddress("Pune");
				Mockito.when(consumerRepository.save(consumer)).thenReturn(consumer);
				
				assertThat(consumerService.updateConsumerById((long)101,consumer)).isEqualTo(consumer);
			}
				catch(Exception e) {}
		}

	  
		
	  

}
